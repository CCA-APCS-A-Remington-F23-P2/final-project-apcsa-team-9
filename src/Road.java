import java.awt.Color;
import java.awt.Graphics;

public class Road {
    private int width;
    private int height;
    private int xPos;
    private int yPos;
    private Color color;

    public Road(int x, int y, Color col) {
        xPos = x;
        yPos = y;
        color = col;
        width = 580;
        height = 40;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color col) {
        color = col;
    }

    public static Color randomColor()
    {
        return new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
    }

    public void draw(Graphics window) 
    {
        window.setColor(getColor());
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}