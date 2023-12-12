import java.io.File;
import java.net.URL;
import java.awt.*;
import javax.imageio.ImageIO;

public class Chicken extends MovingThing
  {
    private int speed;
    private Image image;

    public Chicken(int x, int y, int w, int h, int s) {
      super(x, y, w, h);
      speed = s;
      try
        {
          //first url is broken
          URL url = new URL("https://assets.stickpng.com/images/580b57fcd9996e24bc43c2ab.png");
          URL altUrl=new URL("https://th.bing.com/th/id/R.ec20146cb6f7741e87e26d85d6f9f8ae?rik=IfSCXsabdWVG%2bA&riu=http%3a%2f%2fwww.pngmart.com%2ffiles%2f2%2fChicken-Transparent-PNG.png&ehk=oFy%2fnLaUOdXRAzGWMJKkyv8KlW81PuGj10FaLH93X2E%3d&risl=&pid=ImgRaw&r=0");
          // URL url = getClass().getResource("Images\\Image.jpg"); 
          image = ImageIO.read(altUrl);

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

    // public void moveAndDraw(String direction, Graphics window) {
    //   draw(window, Color.BLACK);
    //   if (direction.equals("LEFT")) {
    //     setX(getX() - speed);
    //   }
    //   if (direction.equals("RIGHT")) {
    //     setX(getX() + speed);
    //   }
    //   if (direction.equals("UP")) {
    //     setY(getY() - speed);
    //   }
    //   if (direction.equals("DOWN")) {
    //     setY(getY() + speed);
    //   }
    //   draw(window);
    // }

    // public void draw(Graphics window)
    // {
    //     draw(window, Color.WHITE);
    // }

    // public void draw(Graphics window, Color col)
    // {
    //     window.setColor(col);
    //     window.fillRect(getX(), getY(), getWidth(), getHeight());
    // }

    public void draw(Graphics window)
    {
        window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }

    public String toString() {
      return super.toString() + getSpeed();
    }
  }