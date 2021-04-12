package dissertation.routetracker;

public class Node {
    private final String id;
    private final int x,y;
    public Node(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
    public String getID() {
        return this.id;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
