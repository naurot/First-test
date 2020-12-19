public abstract class Decorator {
    Decorator item;
    String ingredient;

    public Decorator() {

    }

    public Decorator(String ingredient, Decorator item) {
        this.ingredient = ingredient;
        this.item = item;
    }

    public void printItem() {
        item.printItem();
        System.out.print(item instanceof MenuItem ? "\t" : ", ");
        System.out.print(ingredient);
    }

    public abstract Double getPrice();
}
