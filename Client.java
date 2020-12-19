import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Alice"));
        customers.add(new Customer("Bob"));
        customers.add(new Customer("Carol"));
        customers.add(new Customer("Dan"));


        for (Customer cust : customers)
            System.out.println(cust.getName());
        Menu menu = new Menu();

    }
}
