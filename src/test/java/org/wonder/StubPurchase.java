package org.wonder;

public class StubPurchase extends Purchase {
    private String stubbedPurchaseDescription;

    public StubPurchase(String stubbedPurchaseDescription) {
        super(new Item[0]);
        this.stubbedPurchaseDescription = stubbedPurchaseDescription;
    }

    @Override
    public String asString() {
        return stubbedPurchaseDescription;
    }
}
