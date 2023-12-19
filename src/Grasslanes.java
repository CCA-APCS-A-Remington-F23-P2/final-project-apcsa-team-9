import java.util.*;
import java.awt.*;
public class Grasslanes {
    private ArrayList<Grasslane> grasslanes;
    private BlankLane b1;
    private BlankLane b2;

    public Grasslanes(ArrayList<Integer> yPosWithoutRoad)
    {
        grasslanes=new ArrayList<Grasslane>();
        for(int i=0;i<yPosWithoutRoad.size();i++)
        {
            grasslanes.add(new Grasslane(0, yPosWithoutRoad.get(i)));
        }
        for(int i=0;i<grasslanes.size();i++)
        {
            grasslanes.get(i).generateObstacles();
        }
        b1 = new BlankLane(0, 720);
        b2 = new BlankLane(0, 0);
    }

    public void addGrasslane(Grasslane r)
    {
        grasslanes.add(r);
    }

    public ArrayList<Grasslane> getGrasslanes()
    {
        return grasslanes;
    }

    public void generateObstacles()
    {
        for(int i=0;i<grasslanes.size();i++)
        {
            Grasslane r=grasslanes.get(i);
            r.generateObstacles();
        }
    }

    public ArrayList<Grasslane> getList() {
        return grasslanes;
    }


    public void draw(Graphics window) 
    {
        for(int i=0;i<grasslanes.size();i++)
        {
            Grasslane r=grasslanes.get(i);
            r.draw(window);
        }
        b1.draw(window);
        b2.draw(window);
    }
}

