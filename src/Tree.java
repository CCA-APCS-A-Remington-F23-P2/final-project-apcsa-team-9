import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;


public class Tree extends MovingThing{
    private int speed;
    private Image image; 

    public Tree(int x, int y, int w, int h){
        super(x,y,w,h);
        speed = 0; 
        try
        {
            //broken link
          URL altUrl=new URL("https://th.bing.com/th/id/OIP.R55cOpQhtkAs6R2wtD0QxAHaHa?rs=1&pid=ImgDetMain");
          image  = ImageIO.read(altUrl);
        }
        catch (Exception e)
        {
          System.out.println("Error loading tree image");
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
        

    public void draw(Graphics window)
    {
        window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }

}
