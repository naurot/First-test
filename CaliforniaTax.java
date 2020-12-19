public class CaliforniaTax extends TaxComputation{
    @Override
    public double computeTax(PurchasedItems items, ReceiptDate date) {
        return .075 * items.getTotalCost();
    }

    @Override
    protected boolean taxHoliday(ReceiptDate date) {
        return false;
    }
}
