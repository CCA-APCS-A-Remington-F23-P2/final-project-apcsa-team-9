import java.io.File;
import java.net.URL;
import java.awt.*;
import javax.imageio.ImageIO;

public class Car extends MovingThing
  {
    private int speed;
    private Image image;
    private int randNum; 

    public Car(int x, int y, int w, int h, int s) {
      super(x, y, w, h);
      speed = s;
      randNum = (int)(Math.random()*2) +1; 
      try
        {
            //broken link
          URL url = new URL("https://assets.stickpng.com/images/580b57fcd9996e24bc43c2ab.png");
          URL car1=new URL("https://static.wikia.nocookie.net/crossyroad/images/8/83/11870.png/revision/latest?cb=20151216012703");
          URL car2=new URL("https://static.wikia.nocookie.net/crossyroad/images/2/23/Red_Truck.png/revision/latest?cb=20150128204727");
          if(randNum == 1){
            image  = ImageIO.read(car1);
          }
          else if(randNum == 2){
            image  = ImageIO.read(car2);
          }
          
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