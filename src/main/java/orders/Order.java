package orders;


import Menu.ItemRecipe;
import Menu.Menu;

import static Menu.Menu.findItemMenu;

public class Order {
    private String customerName;
    private ItemRecipe order;
    private String orderName;

    public Order(String customerName, String order) {
        this.customerName = customerName;

        // Parse the order to get the matching itemRecipe.
        // ItemRecipe recipe = Menu.findItemMenu(order);
    }
}
