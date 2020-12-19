public class Coupon100Get10Percent implements AddOn, Coupon {
    @Override
    public boolean applies(PurchasedItems items) {
        return items.getTotalCost() < 100 ? false : true;
    }

    @Override
    public String getLines() {
        return "***** 10% Off Next Visit ******";
    }
    // similar to rebate class
}
