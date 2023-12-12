import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Background extends Canvas implements KeyListener, Runnable
{

  private BufferedImage back;
  private boolean[] keys;
  private Chicken chicken;
<<<<<<< Updated upstream:Background.java
=======
  private Road roadTestOne;
  private Car carTestOne;
  private ArrayList<Road> roads;
>>>>>>> Stashed changes:src/Background.java
  
  public Background()
  {
    setBackground(Color.black);

    keys = new boolean[5];

<<<<<<< Updated upstream:Background.java
    chicken = new Chicken(100, 100, 50, 50, 1, 1);
=======
    chicken = new Chicken(260, 645, 30, 30, 40);
    roadTestOne = new Road(0,100,Color.blue);
    carTestOne = new Car(100,80,50,50,2);
    roads = new ArrayList<Road>();
    
    for(int i = 0; i < 800; i += 40)
    {
      roads.add(new Road(0, i, randomColor()));
    }
>>>>>>> Stashed changes:src/Background.java

    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint( Graphics window )
  {

    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if (back == null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();

    graphToBack.setColor(Color.BLUE);

    if (keys[0]) chicken.move("LEFT");
    else if(keys[1]) chicken.move("RIGHT");
    else if(keys[2]) chicken.move("UP");
    else if(keys[3]) chicken.move("DOWN");
    else if(keys[4]) chicken.move("SPACE");

    carTestOne.move();

    //add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
<<<<<<< Updated upstream:Background.java
    //bullets hit alien

=======

    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,600,800);
    
    for(Road r : roads)
    {
      r.draw(graphToBack);
    }
    carTestOne.draw(graphToBack);
    chicken.draw(graphToBack);
>>>>>>> Stashed changes:src/Background.java
    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void reset()
  {
    setBackground(Color.black);
    setVisible(true);
  }

  private void displayScore(Graphics window, int x, int y)
  {
    window.setFont(new Font("TAHOMA",Font.BOLD,24));
    window.clearRect(x,y-40,200,80);
    window.setColor(Color.WHITE);
    // window.drawString("Score: "+score, x, y);
  }
  private void displayLives(Graphics window, int x, int y)
  {
    window.setFont(new Font("TAHOMA",Font.BOLD,24));
    window.clearRect(x,y-40,200,80);
    window.setColor(Color.WHITE);
    // window.drawString("Lives: "+lives, x, y);
  }

  private void displayLifeLostScreen(Graphics window)
  {
    window.setFont(new Font("TAHOMA",Font.BOLD,12));
    window.clearRect(0,0,800,600);
    window.setColor(Color.WHITE);
    // window.drawString("you lost a life!"+" lives remaining: "+lives+"\n press r to resume", 400, 300);
  }

  private void displayGameLostScreen(Graphics window)
  {
    window.setFont(new Font("TAHOMA",Font.BOLD,12));
    window.clearRect(0,0,800,600);
    window.setColor(Color.WHITE);
    // window.drawString("you lost!! your final score was: "+score,400,300);
  }

  private void displayGameWonScreen(Graphics window)
  {
    window.setFont(new Font("TAHOMA",Font.BOLD,12));
    window.clearRect(0,0,800,600);
    window.setColor(Color.WHITE);
    // window.drawString("you won!! your final score was: "+score,400,300);
  }

  private Color randomColor()
  {
    return new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
  }

  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = true;
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = false;
    }
    repaint();
  }

  public void keyTyped(KeyEvent e)
  {
    //no code needed here
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();

      }
    }catch(Exception e)
    {
    }
  }
}

