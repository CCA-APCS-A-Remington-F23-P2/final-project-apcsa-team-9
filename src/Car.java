import java.io.File;
import java.net.URL;
import java.awt.*;
import javax.imageio.ImageIO;

public class Car extends MovingThing
  {
    private int speed;
    private Image image;

    public Car(int x, int y, int w, int h, int s) {
      super(x, y, w, h);
      speed = s;
      try
        { // No clue why this deprecated constructor works
          URL url = new URL("https://th.bing.com/th/id/R.bbcabe3c054aca53b4ca5690aae822b9?rik=4JcYdpnX2qWNaA&riu=http%3a%2f%2fclipart-library.com%2fimages_k%2fcartoon-car-transparent-background%2fcartoon-car-transparent-background-4.png&ehk=S1bsnvBVQt%2bAv50Fp8WFMSQHw8HoSWfwcK4SqYJAitc%3d&risl=&pid=ImgRaw&r=0");
          image = ImageIO.read(url);
        }
      catch (Exception e)
        {
          System.out.println("Error loading car image");
        }
    }

    public void setSpeed(int s) {
      speed = s;
    }

    public int getSpeed() {
      return speed;
    }

    public void move() {
      setX(getX() + speed); // Always moves right

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

    public String toString() {
      return super.toString() + getSpeed();
    }
  }