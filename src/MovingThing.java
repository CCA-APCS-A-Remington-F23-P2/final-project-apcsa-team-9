import java.awt.Graphics;

public abstract class MovingThing extends Rectangle implements Moveable, Collidable<MovingThing>
{
  public MovingThing()
  {
    super(10,10,10,10);
  }

  public MovingThing(int x, int y)
  {
    super(x,y,10,10);
  }

  public MovingThing(int x, int y, int w, int h)
  {
    super(x,y,w,h);
  }

  public void setPos( int x, int y)
  {
    setX(x);
    setY(y);
  }

  public abstract void move(String direction);
  public abstract void draw(Graphics window);

  public boolean didCollide(MovingThing other)
  {
    int offset = 10;
    if (other instanceof Car) offset = 10;

    if(this.getY()+this.getHeight()<other.getY() || 
      this.getY()>other.getY()+other.getHeight() ||
      this.getX()+this.getWidth()<other.getX()+offset ||
      this.getX()+offset>other.getX()+other.getWidth()) return false;
    return true;
  }

  public String toString()
  {
    return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
  }
}