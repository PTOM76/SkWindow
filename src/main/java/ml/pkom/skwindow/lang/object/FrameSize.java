package ml.pkom.skwindow.lang.object;

public class FrameSize {
    private int width = 300;
    private int height = 200;
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
