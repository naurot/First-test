import java.util.Date;

public class BasicReceipt implements Receipt {
    private String storeInfo;    // store number, store address, phone number
    private String stateCode;    // MD, DE, CA or MA

    private PurchasedItems items;
    private ReceiptDate date;
    private TaxComputation tc;
    double subTotal, tax, total;

    public BasicReceipt(PurchasedItems items) {
        this.items = items;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo;
    }

    public void setTaxComputation(TaxComputation tc) {
        this.tc = tc;
    }

    public void setDate(ReceiptDate date) {
        this.date = date;
    }

    public void prtReceipt() {
        // to implement
        System.out.println("Date: " + date);
        items.emptyCart();
        subTotal = items.getTotalCost();
        System.out.format("Subtotal: %.2f\n", subTotal);
        tax = tc.computeTax(items, date);
        System.out.format("Tax: %.2f\n", tax);
        total = subTotal + tax;
        System.out.format("Total: %.2f\n", total);
    }
}

