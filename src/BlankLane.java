import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class BlankLane extends Rectangle{
    private ArrayList<Grasslane> grasslanes;

    private Color color;
    private ArrayList<MovingThing> obstacles=new ArrayList<MovingThing>();

    public BlankLane(int x, int y) {
        super(x,y,600,40);
        color=Color.YELLOW;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color col) {
        color = col;
    }

    public void draw(Graphics window) 
    {
        window.setColor(getColor());
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
