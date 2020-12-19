import java.util.ArrayList;

public class MDTaxComputation extends TaxComputation {
    ArrayList<String> excludedItems = new ArrayList<String>();

    public double computeTax(PurchasedItems items, ReceiptDate date) {
        // calls private method taxHoliday as part of this computation
        if (excludedItems.size() == 0) {
            excludedItems.add("1406");
            excludedItems.add("1408");
        }
        double subjectToTax;

        subjectToTax = 0;
        if (taxHoliday(date)) {
            System.out.println("Tax Holiday in Maryland");
 //           System.out.println("Tax before: " + subjectToTax);
            for (String itemCode : excludedItems) {
                if (items.containsItem(itemCode))
                    subjectToTax = subjectToTax + items.peekInCart(itemCode).getItemPrice();
            }
        } else return .06 * items.getTotalCost();
 //       System.out.println("Tax after: " + subjectToTax);
        return .06 * subjectToTax;
    }

    @Override
    protected boolean taxHoliday(ReceiptDate date) {
        ReceiptDate beginDate = new ReceiptDate("20200808");
        ReceiptDate endDate = new ReceiptDate("20200816");
        return (date.compareTo(beginDate) > 0) && (date.compareTo(endDate) < 0);
    }

    // returns true if date of receipt within the state’s tax free holiday,
    // else returns false. Supporting method of method computeTax.
}

//  tax computation objects for other states are similar  (to be completed)



