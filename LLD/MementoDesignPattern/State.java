package LLD.MementoDesignPattern;

public class State {
    private int height;
    private int width;
    public State(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }   

    public String toString() {
        return "Height: " + this.height + " Width: " + this.width;
    }
    
}
