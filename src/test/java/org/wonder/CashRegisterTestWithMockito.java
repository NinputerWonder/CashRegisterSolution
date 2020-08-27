package org.wonder;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class CashRegisterTestWithMockito {

    @Test
    public void shouldInvokePrintMethodWithTheRealPurchase() {
        Item items[] = new Item[]{
                new Item("Item 1" , 50) ,
                new Item("Item 2" , 60)
        };
        Purchase purchase = new Purchase(items);
        final Printer mockedPrinter = mock(Printer.class);

        CashRegister cashRegister = new CashRegister(mockedPrinter);
        cashRegister.process(purchase);

        verify(mockedPrinter).print(purchase.asString());
    }

    @Test
    public void shouldInvokePrintMethodWithTheStubbedPurchase() {
        final String stubbedPurchaseDescription = "stubbed purchase";
        Purchase stubbedPurchase = mock(Purchase.class);
        when(stubbedPurchase.asString()).thenReturn(stubbedPurchaseDescription);
        Printer mockedPrinter = mock(Printer.class);

        CashRegister cashRegister = new CashRegister(mockedPrinter);
        cashRegister.process(stubbedPurchase);

        verify(mockedPrinter).print(stubbedPurchaseDescription);
    }
}
