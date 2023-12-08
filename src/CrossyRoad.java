import javax.swing.*;
import java.awt.*;

public class CrossyRoad extends JFrame 
{
  private static final int WIDTH = 600;
  private static final int HEIGHT = 800;

  public CrossyRoad()
  {
    super("CrossyRoad");
    setSize(WIDTH,HEIGHT);

    Background theGame = new Background();
    ((Component)theGame).setFocusable(true);

    getContentPane().add(theGame);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public static void main( String args[] )
  {
    CrossyRoad run = new CrossyRoad();
  }
}