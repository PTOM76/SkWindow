package ml.pkom.skwindow.lang.object;

public class FrameLoc {
    private int x = 500;
    private int y = 250;
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
