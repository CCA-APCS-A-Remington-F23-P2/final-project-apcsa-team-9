import javax.swing.*;

import static Constants.Constants.GameConstants.*;

import java.awt.*;

public class CrossyRoad extends JFrame 
{

  public CrossyRoad()
  {
    super("CrossyRoad");
<<<<<<< Updated upstream:CrossyRoad.java
    setSize(WIDTH+200,HEIGHT+200);
=======
    setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
>>>>>>> Stashed changes:src/CrossyRoad.java

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