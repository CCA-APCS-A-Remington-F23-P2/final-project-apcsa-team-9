import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Road extends Rectangle{
    //color of the road
    private Color color;
    //how fast the cars move on the road
    private int roadSpeed;
    //has value either "LEFT" or "RIGHT", indicates direction the cars on this road travel in
    private String drivingDirection;
    //keeps track of the cars on the road
    private ArrayList<Car> cars=new ArrayList<Car>();

    public Road(int x, int y, Color col, String drivingDirection) {
        super(x,y,600,40);
        color = col;
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

    public int getRoadSpeed()
    {
        return roadSpeed;
    }

    public void setRoadSpeed(int s)
    {
        roadSpeed=s;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color col) {
        color = col;
    }
    
    //generates a random RGB color
    public static Color randomColor()
    {
        return new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
    }

    //see if any of the cars on this road collide with the chicken
    public boolean carCollides(MovingThing other) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).didCollide(other)) {
                return true;
            }
        }
        return false;
    }

    
    //initializes our road with cars, when cars reach the edge, they will be teleported back to the spawn point
    public void generateCars()
    {
        if(drivingDirection.equals("LEFT"))
        {
            int initialCarPos=600;
            while(initialCarPos<=1200)
            {
                int temp=100+(int)(Math.random()*roadSpeed*100);
                cars.add(new Car(initialCarPos,getY()+5,40,30,roadSpeed));
                initialCarPos+=temp;
            }

        }
        else if(drivingDirection.equals("RIGHT"))
        {
            int initialCarPos=0;
            while(initialCarPos>=-600)
            {
                int temp=100+(int)(Math.random()*roadSpeed*100);
                cars.add(new Car(initialCarPos,getY()+5,40,30,roadSpeed));
                initialCarPos-=temp;
            }

        }
    }

    //once cars reach the edge they will be transported back to the start
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

    //used for generating roads
    public static String randomDirection()
    {
        if((int)(Math.random()*2)==0) return "LEFT";
        return "RIGHT";
    }

    // //not used as of now, may be used later
    // public void move(String direction)
    // {
    //     if(direction.equals("DOWN"))
    //     {
    //         setY(getY()+40);
    //         for(int i=0;i<cars.size();i++)
    //         {
    //             Car c=cars.get(i);
    //             c.setY(c.getY()+40);
    //         }
    //     }
    //     if(direction.equals("UP"))
    //     {
    //         setY(getY()-40);
    //         for(int i=0;i<cars.size();i++)
    //         {
    //             Car c=cars.get(i);
    //             c.setY(c.getY()-40);
    //         }
    //     }
        
    // }

    //draws the road and the cars on the road
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