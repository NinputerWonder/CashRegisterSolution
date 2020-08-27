package org.wonder;

import static org.junit.Assert.assertTrue;

public class MockPrinter extends Printer {

    private boolean isInvoked;
    public MockPrinter(){
        isInvoked = false;
    }

    @Override
    public void print(String actualPurchaseDescription){
        isInvoked = true;
    }

    public void verifyThatPrintWasCalledWith(String expectedPurchaseDescription) {
        assertTrue("expected print to be called at least once, print was not called", isInvoked);
    }
}
