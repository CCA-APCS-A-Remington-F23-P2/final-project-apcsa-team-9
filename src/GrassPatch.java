import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class GrassPatch extends Rectangle{
    private Color color;
    private ArrayList<Rock> rocks = new ArrayList<Rock>();

    public GrassPatch(int x, int y) {
        super(x,y,600,40);
        color = Color.GREEN;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color col) {
        color = col;
    }

    //see if any of the rocks on the grass collide with the chicken
    public boolean rockCollide(MovingThing other) {
        for (int i = 0; i < rocks.size(); i++) {
            if (rocks.get(i).didCollide(other)) {
                return true;
            }
        }
        return false;
    }

    
    //initializes our road with cars, when cars reach the edge, they will be teleported back to the spawn point
    public void generateRocks()
    {
        int randX=100+(int)(Math.random()*100);
        rocks.add(new Rock(randX,getY()+5,40,30));
    }

    //draws the road and the cars on the road
    public void draw(Graphics window) 
    {
        window.setColor(getColor());
        window.fillRect(getX(), getY(), getWidth(), getHeight());
        for(Rock r: rocks)
        {
            r.draw(window);
        }
    }
}