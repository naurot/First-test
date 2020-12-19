public class Ingredients extends Decorator {
 //   Decorator item;
 //   String ingredient;

    public Ingredients(String ingredient, Decorator item) {
        super(ingredient, item);
    }

    @Override
    public Double getPrice() {
        return item.getPrice();
    }
}
