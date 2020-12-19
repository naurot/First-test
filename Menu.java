import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Menu {
    // menu consists of appetizers, main courses, and desserts
    // each menu is personalized for each customer by way of a factory
    ArrayList<Decorator> menu = new ArrayList<>();
    Decorator menuItem;

    public Menu() {
        menuItem = new Ingredients("Carrots", new Ingredients("Peas", new Ingredients("Potatoes",
                new Ingredients("Rump Roast", new MenuItem("Pot Roast", "17.99")))));
        menu.add(menuItem);
 /*       menuItem = new MenuItem("Steak au Poivre", "23.99", new Ingredients("Steak",
                new Ingredients("Mushrooms", new Ingredients("Black Pepper", null))));
        menu.add(menuItem);
        menuItem = new MenuItem("Steak Tartare", "18.99", new Ingredients("Ground Beef",
                new Ingredients("Capers", new Ingredients("Onions", new Ingredients("Egg Yolk", null)))));
        menu.add(menuItem);
        menuItem = new MenuItem("Ceasar Salad", "12.99", new Ingredients("Romaine Lettuce",
                new Ingredients("Parmesan", new Ingredients("Sardines", null))));
        menu.add(menuItem);
        menuItem = new MenuItem("Salad Nicoise", "14.99", new Ingredients("Iceberg Lettuce",
                new Ingredients("Olives", new Ingredients("Eggs", null))));
        menu.add(menuItem);
        menuItem = new MenuItem("Clam Chowder", "12.99", new Ingredients("Clams", new Ingredients(
                "Cream", new Ingredients("Onions", new Ingredients("Bacon", null)))));
        menu.add(menuItem);
        menuItem = new MenuItem("Baklava", "7.99",  new Ingredients("Phyllo", new Ingredients("Honey",
                new Ingredients("Walnuts", null))));
        menu.add(menuItem);
        menuItem = new MenuItem("Creme Brulee", "8.99", new Ingredients("Cream", new Ingredients("Sugar",
                new Ingredients("Vanilla", new Ingredients("Almond extract", null)))));
        menu.add(menuItem);
        menuItem = new MenuItem("Mixed Berry Pie", "7.99", new Ingredients("Blueberry",
                new Ingredients("Raspberry", new Ingredients("Strawberry", null))));
        menu.add(menuItem);
 */
        for (Decorator item : menu) {
            item.printItem();
   //         System.out.println(item.getPrice());
        }
    }
}