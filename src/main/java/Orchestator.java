import actors.ExpressoMachine;
import actors.ExpressoMachineManager;
import actors.Roomba;
import orders.OrderFactory;
import console.FileReaderUtil;
import orders.OrderQueue;

import java.util.ArrayList;
import java.util.List;

public class Orchestator {
    private final String mapFileName;
    private final String missionFileName;
    private Roomba roomba;
    private ExpressoMachineManager machineManager;


    public Orchestator(String mapFile, String missionFile) {
        mapFileName = mapFile;
        missionFileName = missionFile;
        machineManager = new ExpressoMachineManager();
    }

    public void start() {
        List<String> encryptedCommands = FileReaderUtil.readMissionFile(missionFileName);
        interpretOrders(encryptedCommands);
        // Init the position of the roomba and the expresso machines
        roomba = new Roomba(3,3);
        // TODO Use real machine position from map
        machineManager.add(new ExpressoMachine(0,0));
        machineManager.add(new ExpressoMachine(5,5));
    }

    // Decrypting the base 64 orders and adding them to the order queue.
    private void interpretOrders(List<String> encryptedCommands) {
        for( String command : encryptedCommands) {
            System.out.println("Order: " + command);
            OrderQueue.getInstance().add( OrderFactory.createCommand(command));
        }
    }

    private List<String> getRecipesForRoomba() {
        return null;
    }

    // This is the event loop to serve the orders of the clients
    private void serveOrders() {
        while(OrderQueue.getInstance().size() > 0) {



        }
    }


}
