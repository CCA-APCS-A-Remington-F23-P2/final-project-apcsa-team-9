import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;
import java.util.*;

public class Deadzone extends MovingThing {
    private int speed;
    private Image image; 

    public Deadzone()
    {
        super(0,0,30,30);
        speed=0;
        try
        {
            //broken link
          URL altUrl=new URL("https://www.pngall.com/wp-content/uploads/5/Red-X-Letter-PNG-Clipart.png");
          image  = ImageIO.read(altUrl);
        }
        catch (Exception e)
        {
          System.out.println("Error loading deadzone image");
        }
    }

    public Deadzone(int x, int y, int w, int h){
        super(x,y,w,h);
        speed = 0; 
        try
        {
            //broken link
          URL altUrl=new URL("https://www.pngall.com/wp-content/uploads/5/Red-X-Letter-PNG-Clipart.png");
          image  = ImageIO.read(altUrl);
        }
        catch (Exception e)
        {
          System.out.println("Error loading deadzone image");
        }
    }

    public void setSpeed(int s) {
        speed = s;
    }
  
    public int getSpeed() {
        return speed;
    }

    public void move(String direction) 
    {}

    public void moveToNewLocation(ArrayList<Integer> yPosWithRoad)
    {
        setX(((int)(Math.random()*14))*40+5);
        int temp=yPosWithRoad.get((int)(Math.random()*yPosWithRoad.size()))+5;
        while(temp>640)
        {
            temp=yPosWithRoad.get((int)(Math.random()*yPosWithRoad.size()))+5;
        }
        setY(temp);
    }
        

    public void draw(Graphics window)
    {
        window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }
}
