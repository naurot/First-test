import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Receipt receipt;
        PurchasedItems purchasedItems;
        ReceiptFactory factory;
        ReceiptDate date;
        Store myStore;
        String ans;
        String month, day, year = "";
        int storeNum;
        //      Date date = new Date();
        // 1.	Creates a PurchasedItems object.
        factory = new ReceiptFactory();
        do {
 //           factory = new ReceiptFactory();
            date = ReceiptDate.getDate();
            System.out.println("Date =  " + date);
            purchasedItems = new PurchasedItems();
            ReceiptFactory.setStore(getStore());
            myStore = new Store();
            purchaseMenu(purchasedItems, myStore);
            receipt = factory.getReceipt(purchasedItems, date);
            receipt.prtReceipt();
            System.out.print("\nAgain: ");
            ans = cin.nextLine();
        } while (ans.length() > 0 && ans.substring(0, 1).toUpperCase().equals("Y"));
    }

    public static void purchaseMenu(PurchasedItems purchasedItems, Store myStore) {
        Scanner cin = new Scanner(System.in);
        String ans;
        for (StoreItem item : myStore.getStoreItems()) {
            System.out.print("Purchase item: " + item.getItemDescription() + " Price " + item.getItemPrice() + " Y/N: ");
            ans = cin.nextLine();
            if (ans.length() > 0 && ans.substring(0, 1).toUpperCase().equals("Y")) {
                purchasedItems.addItem(item);
            }
        }
    }

    public static int getStore() {
        Scanner cin = new Scanner(System.in);
        int i = 0;
        do {
            for (i = 0; i < ReceiptFactory.header_list.size(); i++)
                System.out.println(ReceiptFactory.header_list.get(i) + " [" + i + "]");
            System.out.print("Enter Store Number: ");
            i = cin.nextInt();
            cin.nextLine();
        } while (!(i >= 0 && i < ReceiptFactory.header_list.size()));
        return i;
    }
}