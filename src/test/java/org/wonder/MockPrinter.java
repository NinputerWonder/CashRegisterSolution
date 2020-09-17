package org.wonder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MockPrinter extends Printer {

    private boolean isInvoked;
    private String actualPurchaseDescription;

    public MockPrinter(){
        isInvoked = false;
        actualPurchaseDescription = null;
    }

    @Override
    public void print(String actualPurchaseDescription){
        isInvoked = true;
        this.actualPurchaseDescription = actualPurchaseDescription;
    }

    public void verifyPrintWasCalledWith(String expectedPurchaseDescription) {
        verifyThatPrintWasCalled();
        assertEquals("expected print to be called with '" + expectedPurchaseDescription + "', but was called with '" + actualPurchaseDescription + "'",
                expectedPurchaseDescription, actualPurchaseDescription);
    }

    public void verifyThatPrintWasCalled() {
        assertTrue("expected print to be called at least once, print was not called", isInvoked);
    }
}
