package actors;

import java.awt.*;

public class Actor {
    private Point pos;
    private static int maxX;
    private static int maxY;
    /**
     * @param x The x position of the actor in the map, with [0;0] as the top left corner
     * @param y The y position of the actor in the map.
     */
    public Actor(int x, int y) {
        pos = new Point();
        pos.x = x;
        pos.y = y;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(int x, int y) {
        pos.x = x <= maxX ? x : maxX;
        pos.y = y <= maxY ? y : maxY;
    }

    public boolean isBesideOf(Actor other) {
        boolean isRightOf = pos.x + 1 == other.getPos().x;
        boolean isLeftOf = pos.x - 1 == other.getPos().x;
        boolean isTopOf = pos.y - 1 == other.getPos().y;
        boolean isBottomOf = pos.y + 1 == other.getPos().y;
    }
}
