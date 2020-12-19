public class BestBuyBanner implements Heading, AddOn{
    private String storeInfo;

    public BestBuyBanner(String storeInfo){
        this.storeInfo = storeInfo;
    }
    @Override
    public boolean applies(PurchasedItems items) {
        return true;
    }

    @Override
    public String getLines() {
        return "Best Buy: " + storeInfo;
    }
}
