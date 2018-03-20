import orders.OrderFactory;
import console.FileReaderUtil;
import orders.OrderQueue;

import java.util.List;

public class Orchestator {
    private final String mapFileName;
    private final String missionFileName;

    public Orchestator(String mapFile, String missionFile) {
        mapFileName = mapFile;
        missionFileName = missionFile;
    }

    public void start() {
        List<String> encryptedCommands = FileReaderUtil.readMissionFile(missionFileName);
        interpretOrders(encryptedCommands);

    }

    // Decrypting the base 64 orders and adding them to the order queue.
    private void interpretOrders(List<String> encryptedCommands) {
        for( String command : encryptedCommands) {
            System.out.println("Order: " + command);
            OrderQueue.getInstance().add( OrderFactory.createCommand(command));
        }
    }

    private List<String> getRecipesForRoomba()


}
