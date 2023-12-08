import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Moveable, Collidable<MovingThing>
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  public MovingThing()
  {
    xPos = 10;
    yPos = 10;
    width = 10;
    height = 10;
  }

  public MovingThing(int x, int y)
  {
    xPos = x;
    yPos = y;
    width = 10;
    height = 10;
  }

  public MovingThing(int x, int y, int w, int h)
  {
    xPos=x;
    yPos=y;
    width=w;
    height=h;
  }

  public void setPos( int x, int y)
  {
    xPos=x;
    yPos=y;
  }

  public void setX(int x)
  {
    xPos=x;
  }

  public void setY(int y)
  {
    yPos=y;
  }

  public int getX()
  {
    return xPos;   
  }

  public int getY()
  {
    return yPos;  
  }

  public void setWidth(int w)
  {
    width=w;
  }

  public void setHeight(int h)
  {
    height=h;

  }

  public int getWidth()
  {
    return width;  
  }

  public int getHeight()
  {
    return height;  
  }

  public abstract void move(String direction);
  public abstract void draw(Graphics window);

  public boolean didCollide(MovingThing other)
  {
    if(this.getY()+this.getHeight()<other.getY() || 
      this.getY()>other.getY()+other.getHeight() ||
      this.getX()+this.getWidth()<other.getX() ||
      this.getX()>other.getX()+other.getWidth()) return false;
    return true;
  }

  public String toString()
  {
    return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
  }
}