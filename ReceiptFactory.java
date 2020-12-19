import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReceiptFactory {
    static ArrayList<String> header_list = new ArrayList<>();  // contains line with “Best Buy”, store_num, street_addr, phone
    static ArrayList<TaxComputation> state_code_list = new ArrayList<>();
    static String header;
    static TaxComputation state_code;

    private TaxComputation[] taxComputationsObjs;    // tax computation objects (for each state)
    private AddOn[] addOns;   // secondary header, rebate and coupon add-ons

    public ReceiptFactory() {  // constructor
        // 1. Populates array of StateComputation objects and array of AddOn objects (as if downloaded
        //from the BestBuy web site).
        taxComputationsObjs = new TaxComputation[4];
        taxComputationsObjs[0] = new CaliforniaTax();
        taxComputationsObjs[1] = new DelewareTax();
        taxComputationsObjs[2] = new MassachusettesTax();
        taxComputationsObjs[3] = new MDTaxComputation();

        addOns = new AddOn[3];
        addOns[0] = new Coupon100Get10Percent();
        addOns[1] = new HolidayGreeting();
        addOns[2] = new Rebate1406();
        //addOn bestbuy banner?

        // 2. Reads config file to assign store_num, street_addr, etc.
        try {
            Scanner fin = new Scanner(new File("store.cfg"));
            TaxComputation store_state_code = null;
            String store_header;
            String state;
            while (fin.hasNextLine()) {
                store_header = fin.nextLine();
                state = fin.nextLine();
                store_header = store_header + ", " + state;
                switch (state.substring(0, 2)) {
                    case "CA":
                        store_state_code = taxComputationsObjs[0];
                        break;
                    case "DE":
                        store_state_code = taxComputationsObjs[1];
                        break;
                    case "MA":
                        store_state_code = taxComputationsObjs[2];
                        break;
                    case "MD":
                        store_state_code = taxComputationsObjs[3];
                        break;
                    default:
                        System.out.println("State not recognized");
                        break;
                }
                header_list.add(store_header);
                state_code_list.add(store_state_code);
            }
        } catch (FileNotFoundException eMsg) {
            System.out.println(eMsg);
        }

        // 3.	Based on the state code (e.g., “MD”, from the config file) stores appropriate
        //StateComputation object to be used on all receipts.
        //      switch ()
        //      state_code = new
    }


    public static void setStore(int i) {
        state_code = state_code_list.get(i);
        header = header_list.get(i);
        System.out.println("Your store is:\n" + header);
    }

    public Receipt getReceipt(PurchasedItems items, ReceiptDate date) {
        Receipt receipt = new BasicReceipt(items);
        Decorator altReceipt;
        // 1.	Sets the current date of the BasicReceipt.
        ((BasicReceipt) receipt).setDate(date);
        // 2.	Attaches the StateComputation object to the BasicReceipt (by call to the setComputation
        // method of BasicReceipt).
        ((BasicReceipt) receipt).setTaxComputation(state_code);
        ((BasicReceipt) receipt).setStoreInfo(header);
        altReceipt = new PreDecorator(new BestBuyBanner(((BasicReceipt) receipt).getStoreInfo()), receipt);
        // 3.	Traverses over all AddOn objects, calling the applies method of each. If an AddOn object
        //applies, then determines if the AddOn is of type SecondaryHeader, Rebate, or Coupon.
        //        If of type SecondaryHeader, then creates a PreDecorator for other AddOn. If of type Rebate or
        //Coupon, then creates a PostDecorator.
        for (AddOn addon : addOns) {
            if (addon.applies(items)) {
                if (addon instanceof SecondaryHeading) {
                    //create PreDecorator
                    altReceipt = new PreDecorator(addon, altReceipt);
                } else {
                    //create PostDecorator
                    altReceipt = new PostDecorator(addon, altReceipt);
                }
            }
        }
        // 4.	Links in the decorator object based on the Decorator design pattern.

        // 5.	Adds current date to

        // 6.	Returns decorated BasicReceipt object as type Receipt.
        return altReceipt;
    }
}
