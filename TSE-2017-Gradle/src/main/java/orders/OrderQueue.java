package orders;
import java.util.ArrayList;

// This class is a singleton that contains all of the orders that are not done.
public class OrderQueue {
    private ArrayList<Order> orders;
    private static OrderQueue instance;

    // Private to prevent external classes from creating an instance.
    private OrderQueue() {
        // Do nothing since it is a singleton
    }

    // Method to access the instance of the singleton.
    public OrderQueue getInstance() {
        if(instance == null) {
            instance = new OrderQueue();
        }

        return instance;
    }



}
