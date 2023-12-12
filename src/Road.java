import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import static java.lang.System.*;

public class Road {
    private int width;
    private int height;
    private int xPos;
    private int yPos;
    private Color color;
    private final int roadSpeed;
    //has value either "LEFT" or "RIGHT", indicates direction the cars on this road travel in
    private String drivingDirection;
    private ArrayList<Car> cars=new ArrayList<Car>();
    //helper vars for generating cars
    private long timeSinceLastCarAdded;
    private long timeToExceed;
    private int count=0;

    public Road(int x, int y, Color col, String drivingDirection) {
        xPos = x;
        yPos = y;
        color = col;
        width = 600;
        height = 40;
        this.drivingDirection = drivingDirection;
        roadSpeed = (int)(Math.random()*3)+1;
    }

    public String getDrivingDirection()
    {
        return drivingDirection;
    }

    public void setDrivingDirection(String d)
    {
        drivingDirection=d;
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

    
    //adds cars to our road randomly
    public void generateCars()
    {
        count++;
        if(count==1)
        {
            timeSinceLastCarAdded=System.nanoTime();
            timeToExceed=(long)(Math.random()*2000000000)+2000000000;
        }
        if(System.nanoTime()-timeSinceLastCarAdded>timeToExceed)
        {
            if(drivingDirection.equals("LEFT")) cars.add(new Car(600,yPos,50,30, roadSpeed));
            else cars.add(new Car(0,yPos,50,30, roadSpeed));
            count=0;
        }
    }

    //removes cars once they move off the screen
    public void cleanUpEdges()
    {
        for(int i=0;i<cars.size();i++)
        {
            if(cars.get(i).getX()<-20 || cars.get(i).getX()>620)
            {
                cars.remove(i);
                i--;
            }
        }
    }

    public void draw(Graphics window) 
    {
        window.setColor(getColor());
        window.fillRect(getX(), getY(), getWidth(), getHeight());
        for(Car c:cars)
        {
            c.move(drivingDirection);
            c.draw(window);
        }
    }
}