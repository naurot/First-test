public class StoreItem  {
    private String itemCode;  		// e.g., 3010
    private String itemDescription;  	// e.g., Dell Laptop
    private String itemPrice;

    public StoreItem(String code, String descript, String price) {
        itemCode = code;
        itemDescription = descript;
        itemPrice = price;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getItemPrice() {
        return Double.parseDouble(itemPrice);
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}

