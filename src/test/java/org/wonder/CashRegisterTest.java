package org.wonder;

import org.junit.Test;



public class CashRegisterTest {

    @Test
    public void shouldInvokePrintMethodWithTheRealPurchase()
    {
        Item items[] = new Item[] {
                new Item("Item 1", 50),
                new Item("Item 2", 60)
        };
        Purchase purchase = new Purchase(items);
        MockPrinter printer = new MockPrinter();

        CashRegister cashRegister = new CashRegister(printer);
        cashRegister.process(purchase);

        printer.verifyThatPrintWasCalled();
        printer.verifyThatPrintWasCalledWith(purchase.asString());
    }
}
