import java.util.*;

import javax.imageio.ImageIO;

import java.awt.*;
import java.net.URL;


public class Rock extends MovingThing{
    private int speed;
    private Image image; 

    public Rock(int x, int y, int w, int h){
        super(x,y,w,h);
        speed = 0; 
        try
        {
            //broken link
          URL altUrl=new URL("https://static.wikia.nocookie.net/crossyroad/images/b/b8/Moonrock.png/revision/latest?cb=20220522224223");
          image  = ImageIO.read(altUrl);
        }
      catch (Exception e)
        {
          System.out.println("Error loading rock image");
        }
    }

    public void setSpeed(int s) {
        speed = s;
    }
  
    public int getSpeed() {
        return speed;
    }

    public void move(String direction) {

        if (direction.equals("LEFT")) {
          setX(getX() - speed);
        }
        else if (direction.equals("RIGHT")) {
          setX(getX() + speed);
        }
        else if (direction.equals("UP")) {
          setY(getY() - speed);
        }
        else if (direction.equals("DOWN")) {
          setY(getY() + speed);
        }
    }
        

    public void draw(Graphics window)
    {
        window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }

}
