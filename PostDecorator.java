public class PostDecorator extends Decorator {
    private AddOn a;

    public PostDecorator(AddOn a, Receipt r) {
        super(r);
        this.a = a;
    }

    @Override
    public void prtReceipt() {
        callTrailer();
        System.out.println(a.getLines());
    }
// similar, except that prtReceipt print the add on information
// after the other parts of the receipt are printed
}

