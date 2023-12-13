public class Rectangle {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    public Rectangle(int x, int y, int w, int h)
    {
        xPos=x;
        yPos=y;
        width=w;
        height=h;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public void setWidth(int w) {
        width=w;
    }

    public void getHeight(int h) {
        height=h;
    }

}
