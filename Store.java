import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    static ArrayList<StoreItem> storeItems;

    public Store(){
        storeItems = new ArrayList<StoreItem>();
        String itemString, itemCode, itemDescription, itemPrice;
        StoreItem item = null;
        try{
            Scanner fin = new Scanner(new File("StoreItems.dat"));
            while (fin.hasNext()){
                itemString = fin.nextLine();
                itemCode = getNext(itemString);
                itemString = itemString.substring(itemCode.length()+1);
                itemDescription = getNext(itemString);
                itemString = itemString.substring(itemDescription.length()+1);
                itemPrice = itemString;
                item = new StoreItem(itemCode, itemDescription, itemPrice);
                storeItems.add(item);
                fin.nextLine();
            }
        } catch (FileNotFoundException eMsg) {
            System.out.println(eMsg);
        }
    }

    public static ArrayList<StoreItem> getStoreItems(){
        return storeItems;
    }
    public String getNext(String string){
        return string.substring(0, string.indexOf(","));
    }
}
