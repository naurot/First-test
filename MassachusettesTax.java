import java.util.ArrayList;

public class MassachusettesTax extends TaxComputation {
    ArrayList<String> includedItems = new ArrayList<>();// list not subject to tax

    @Override
    public double computeTax(PurchasedItems items, ReceiptDate date) {
        if (includedItems.size() == 0) {
            includedItems.add("0100");
            includedItems.add("0110");
            includedItems.add("0201");
            includedItems.add("0202");
            includedItems.add("0418");
            includedItems.add("0419");
            includedItems.add("1406");
            includedItems.add("1408");
        }
        double subjectToTax;
        subjectToTax = items.getTotalCost();
        if (taxHoliday(date)) {
            System.out.println("Tax Holiday in Massachusettes");
            for (String itemCode : includedItems)
                if (items.containsItem(itemCode)) {
                    subjectToTax = subjectToTax - items.peekInCart(itemCode).getItemPrice();
                }
        }
        return .075 * subjectToTax;
    }

    @Override
    protected boolean taxHoliday(ReceiptDate date) {
// aug 29 and aug 30 , 2020
        ReceiptDate beginDate = new ReceiptDate("20200828");
        ReceiptDate endDate = new ReceiptDate("20200831");
//        if (date.compareTo(beginDate) > 0 && date.compareTo(endDate) < 0)
//            System.out.println("Tax holiday in Mass");
//        else System.out.println("Not Tax Holiday in Mass");
        return (date.compareTo(beginDate) > 0 && date.compareTo(endDate) < 0);
    }
}
