public class DelewareTax extends TaxComputation{
    @Override
    public double computeTax(PurchasedItems items, ReceiptDate date) {
        return 0;
    }

    @Override
    protected boolean taxHoliday(ReceiptDate date) {
        return false;
    }
}
