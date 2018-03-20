package orders;
import java.util.ArrayList;
import java.util.List;

// This class is a singleton that contains all of the orders that are not done.
public class OrderQueue {
    // We are using a List instead of a queue because we need to lookup for the most optimal
    // orders, not only the first one.
    private List<Order> orders;
    private static OrderQueue instance;

    // Private to prevent external classes from creating an instance.
    private OrderQueue() {
        orders = new ArrayList<>();

    }

    // Method to access the instance of the singleton.
    public static OrderQueue getInstance() {
        if(instance == null) {
            instance = new OrderQueue();
        }

        return instance;
    }


    public void add(Order order) {
        this.orders.add(order);
    }

    public Order get(int index) {
        return this.orders.get(index);
    }

    public Order getAndRemove(int index) {
        return this.orders.remove(index);
    }

    public List<Order> getAll() {
        return this.orders;
    }
}
