package navigation;


import java.util.ArrayList;
import java.util.Queue;

public class PathingLogic {
    //Current roomba location information
    private NAVIGATION_DIRECTION CurrentFacing;
    private int[] CurrentLocation;

    //Current map layout and destination
    private String MapLayout;
    private char Destination;

    //The location collections for clients, machines and walls
    private EntityPair[][] EntitiesMap;



    public PathingLogic (String mapLayout, char destination){
        this.CurrentFacing  = NAVIGATION_DIRECTION.NORTH;
        this.MapLayout = mapLayout;
        this.Destination = destination;

        //Analyse the map to fill in the location collections
        this.AnalyzeMap();

    }

    private void AnalyzeMap(){
        int x = 0;
        int y = 0;
        for (char ch: this.MapLayout.toCharArray()) {
            if(ch == '\n')
                y++;
            EntitiesMap[x][y] = (new EntityPair(new int[] {x,y},IdentifyEntity(ch)));
            x++;
        }
    }


    private ENTITY_TYPE IdentifyEntity(char entityChar){
        //Possible Customer IDs and Espresso machine IDs
        final String CUSTOMERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String ESPRESSO_MACHINES = "123456789";

        if(CUSTOMERS.indexOf(entityChar) > -1)
            return ENTITY_TYPE.CUSTOMER;
        else if(ESPRESSO_MACHINES.indexOf(entityChar) > -1)
            return ENTITY_TYPE.ESPRESSO_MACHINE;
        else if(entityChar == '#')
            return ENTITY_TYPE.WALL;
        else
            return ENTITY_TYPE.EMPTY;
    }


    private class EntityPair{
        public int[] Coordinate;
        public ENTITY_TYPE Type;
        public EntityPair(int[] coords, ENTITY_TYPE type){
            this.Coordinate = coords;
            this.Type = type;
        }
    }

    public Queue<String> GeneratePath(){
        return null;
    }



}
