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

    public boolean carCollides(MovingThing other) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).didCollide(other)) {
                return true;
            }
        }
        return false;
    }

    
    //adds cars to our road randomly
    public void generateCars()
    {
        if(drivingDirection.equals("LEFT"))
        {
            int initialCarPos=600;
            while(initialCarPos<=1200)
            {
                int temp=100+(int)(Math.random()*roadSpeed*100);
                cars.add(new Car(initialCarPos,yPos+5,40,30,roadSpeed));
                initialCarPos+=temp;
            }

        }
        else if(drivingDirection.equals("RIGHT"))
        {
            int initialCarPos=0;
            while(initialCarPos>=-600)
            {
                int temp=100+(int)(Math.random()*roadSpeed*100);
                cars.add(new Car(initialCarPos,yPos+5,40,30,roadSpeed));
                initialCarPos-=temp;
            }

        }
    }

    //removes cars once they move off the screen
    public void cleanUpEdges()
    {
        for(int i=0;i<cars.size();i++)
        {
            if(drivingDirection.equals("LEFT"))
            {
                if(cars.get(i).getX()<-20)
                {
                    cars.get(i).setX(800);
                }

            }
            else if(drivingDirection.equals("RIGHT"))
            {
                if(cars.get(i).getX()>620)
                {
                    cars.get(i).setX(-200);
                }

            }
            
        }
    }

    public static String randomDirection()
    {
        if((int)(Math.random()*2)==0) return "LEFT";
        return "RIGHT";
    }

    public void move(String direction)
    {
        if(direction.equals("DOWN"))
        {
            yPos+=40;
            for(int i=0;i<cars.size();i++)
            {
                Car c=cars.get(i);
                c.setY(c.getY()+40);
            }
        }
        if(direction.equals("UP"))
        {
            yPos-=40;
            for(int i=0;i<cars.size();i++)
            {
                Car c=cars.get(i);
                c.setY(c.getY()-40);
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