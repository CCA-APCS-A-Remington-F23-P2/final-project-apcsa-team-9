import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Grasslane extends Rectangle{
    //color of the grasslane
    private Color color;
    private ArrayList<MovingThing> obstacles=new ArrayList<MovingThing>();

    public Grasslane(int x, int y) {
        super(x,y,600,40);
        color=Color.GREEN;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color col) {
        color = col;
    }

    public ArrayList<MovingThing> getObstacles()
    {
        return obstacles;
    }

    

    public void generateObstacles()
    {
        for(int i=0;i<520;i+=40)
        {
            boolean obstacleHere=false;
            if((int)(Math.random()*100)<=29) obstacleHere=true;
            if(obstacleHere)
            {
                if((int)(Math.random()*2)==0) obstacles.add(new Rock(i+5,getY()+5,30,30));
                else obstacles.add(new Tree(i+5,getY()+5,30,30));
            }
        }
    }


    //draws the grasslane and the rocks and trees on it
    public void draw(Graphics window) 
    {
        window.setColor(getColor());
        window.fillRect(getX(), getY(), getWidth(), getHeight());
        for(MovingThing m:obstacles)
        {
            m.draw(window);
        }
    }
}
