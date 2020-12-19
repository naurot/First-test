import java.lang.reflect.Array;
import java.util.ArrayList;

public class PurchasedItems  {
    private ArrayList<StoreItem> items;
    int index;

    public PurchasedItems() {
        items = new ArrayList<StoreItem>();
    }

    public void addItem(StoreItem item) {
        //insert code
        items.add(item);
    }

    public double getTotalCost() {
        //insert code
        double totalCost = 0.0;
        for (StoreItem item : items){
            totalCost = totalCost + item.getItemPrice();
        }
        return totalCost;
    }

    public boolean containsItem(String itemCode) {
        //insert code
        boolean retVal = false;
        for (StoreItem item : items){
            if (item.getItemCode().equals(itemCode))
                retVal = true;
        }
        return retVal;
    }
    public StoreItem peekInCart(String itemCode){
        StoreItem retItem = null;
        for (StoreItem item : items)
            if (item.getItemCode().equals(itemCode))
                retItem = item;
        return retItem;
    }
    public void emptyCart(){
        for (StoreItem item : items)
        System.out.println(item.getItemCode() + " " + item.getItemDescription() + " " + item.getItemPrice());
    }
}

