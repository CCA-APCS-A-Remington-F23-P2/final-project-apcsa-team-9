import java.io.File;
import java.net.URL;
import java.awt.*;
import javax.imageio.ImageIO;

public class Chicken extends MovingThing
  {
    private int speed;
    private Image image;

    public Chicken(int x, int y, int w, int h, Color c, int s) {
      super(x, y, w, h);
      speed = s;
      c = Color.WHITE;
      try
        {
          URL url = new URL("https://assets.stickpng.com/images/580b57fcd9996e24bc43c2ab.png");
          image  = ImageIO.read(url);
        }
      catch (Exception e)
        {
          System.out.println("Error loading chicken image");
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
      if (direction.equals("RIGHT")) {
        setX(getX() + speed);
      }
      if (direction.equals("UP")) {
        setY(getY() - speed);
      }
      if (direction.equals("DOWN")) {
        setY(getY() + speed);
      }
    }

    // public void draw(Graphics window)
    // {
    //     draw(window, Color.WHITE);
    // }

    // public void draw(Graphics window, Color col)
    // {
    //     window.setColor(col);
    //     window.fillRect(getX(), getY(), getWidth(), getHeight());
    // }

    public void draw( Graphics window )
    {
        window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }

    public String toString() {
      return super.toString() + getSpeed();
    }
  }