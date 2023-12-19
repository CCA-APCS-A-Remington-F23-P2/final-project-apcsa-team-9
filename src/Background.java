import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;


public class Background extends Canvas implements KeyListener, Runnable
{

  private BufferedImage back;
  private boolean[] keys;
  private Chicken chicken;
  private Roads roads;
  private Grasslanes grasslanes;
  private boolean gamePaused=false;
  private Coin coin;
  private int score;
  private int highestScore;
  //^^ Incorporate the roads and draw them on the screen later
  
  public Background()
  {
    setBackground(Color.BLUE);

    keys = new boolean[5];
    score=0;
    highestScore=0;

    chicken = new Chicken(285, 645, 30, 30, 40);
    roads=new Roads();
    System.out.println(roads.getyPosWithoutRoad());
    System.out.println(roads.getyPosWithRoad());
    coin=new Coin(205,roads.getyPosWithRoad().get(0)+5,30,30);
    grasslanes=new Grasslanes(roads.getyPosWithoutRoad());
    roads.generateCars();

    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint(Graphics window)
  {


    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if (back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();
     

    if (keys[0] && chicken.moveIsLegal(grasslanes, "LEFT")) {
      chicken.move("LEFT");
      keys[0] = false;
    }
    else if (keys[1] && chicken.moveIsLegal(grasslanes, "RIGHT")) {
      chicken.move("RIGHT");
      keys[1] = false;
    }
    else if (keys[2] && chicken.moveIsLegal(grasslanes, "UP")) {
      //roads.move("DOWN");
      chicken.move("UP");
      keys[2] = false;
    }
    else if (keys[3] && chicken.moveIsLegal(grasslanes, "DOWN")) {
      //roads.move("UP");
      chicken.move("DOWN");
      keys[3] = false;
    }
    if (keys[4]) {
      reset();
      keys[4]=false;
    }
    

    //add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
    //bullets hit alien
    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,600,800);
    if(gamePaused)
    {
      if(score>highestScore) highestScore=score;
      displayGameLostScreen(graphToBack);
      twoDGraph.drawImage(back, null, 0, 0);
      return;
    }

    for (int i = 0; i < roads.getList().size(); i++) {
      if (roads.getList().get(i).carCollides(chicken)) {
        //ADD IN THE YOU DIE SCREEN CUZ U DO
        displayGameLostScreen(graphToBack);
        gamePaused=true;
      }
    }

    if(chicken.didCollide(coin))
    {
      score++;
      coin.moveToNewLocation(roads.getyPosWithRoad());
    }
    
    roads.cleanUpEdges();
    roads.draw(graphToBack);
    coin.draw(graphToBack);
    grasslanes.draw(graphToBack);
    chicken.draw(graphToBack);
    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void reset()
  {
    setBackground(Color.BLUE);
    chicken = new Chicken(285, 645, 30, 30, 40);
    roads=new Roads();
    grasslanes=new Grasslanes(roads.getyPosWithoutRoad());
    roads.generateCars();
    setVisible(true);
    gamePaused=false;
    score=0;
    coin=new Coin(205,roads.getyPosWithRoad().get(0)+5,30,30);
  }

  public void displayScore(Graphics window, int x, int y)
  {
    window.setFont(new Font("TAHOMA",Font.BOLD,24));
    window.clearRect(x,y-40,200,80);
    window.setColor(Color.WHITE);
    // window.drawString("Score: "+score, x, y);
  }
  public void displayLives(Graphics window, int x, int y)
  {
    window.setFont(new Font("TAHOMA",Font.BOLD,24));
    window.clearRect(x,y-40,200,80);
    window.setColor(Color.WHITE);
    // window.drawString("Lives: "+lives, x, y);
  }

  public void displayLifeLostScreen(Graphics window)
  {
    window.setFont(new Font("TAHOMA",Font.BOLD,12));
    window.clearRect(0,0,800,600);
    window.setColor(Color.WHITE);
    // window.drawString("you lost a life!"+" lives remaining: "+lives+"\n press r to resume", 400, 300);
  }

  public void displayGameLostScreen(Graphics window)
  {
    window.setFont(new Font("TAHOMA",Font.BOLD,12));
    window.clearRect(0,0,600,800);
    window.setColor(Color.WHITE);
    window.drawString("you lost!! your final score was: "+score,200,300);
    window.drawString("press r to restart",200,400);
    window.drawString("session high score: "+highestScore,200,500);
  }

  public void displayGameWonScreen(Graphics window)
  {
    window.setFont(new Font("TAHOMA",Font.BOLD,12));
    window.clearRect(0,0,800,600);
    window.setColor(Color.WHITE);
    // window.drawString("you won!! your final score was: "+score,400,300);
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
    if (e.getKeyCode() == KeyEvent.VK_R && gamePaused)
    {
      keys[4]=true;
    }
    repaint();
  }

  //keyreleased probably not needed, see lines 56-59
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
    if (e.getKeyCode() == KeyEvent.VK_R && gamePaused)
    {
      keys[4]=true;
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
        Thread.currentThread().sleep(17);
        repaint();

      }
    }catch(Exception e)
    {
    }
  }
}
