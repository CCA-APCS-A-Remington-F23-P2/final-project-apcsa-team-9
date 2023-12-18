import java.util.*;
import java.awt.*;
public class Grasslanes {
    private ArrayList<Grasslane> grasslanes;

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
    }



}

