public class MenuItem extends Decorator{
    // an item on the menu - either appetizer, main course, or dessert
    // has a cost
    // made up of ingredients
    // ingredients are Decorators of the dish
    int itemNum;
    private String description;
    private String cost;

    public MenuItem(String description, String price){
        this.description = description;
        cost = price;
    }

    @Override
    public void printItem() {
        System.out.println(description + "\t\t$" + getPrice());
    }

    public Double getPrice(){
        return Double.parseDouble(cost);
    }
}
