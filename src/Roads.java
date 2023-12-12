import java.util.*;
import java.awt.*;
public class Roads {
    private ArrayList<Road> roads;

    public Roads()
    {
        roads=new ArrayList<Road>();
        for(int i=0;i<=760;i+=40)
        {
            int rand=(int)(Math.random()*2);
            if(rand==0) roads.add(new Road(0,i,Road.randomColor(),"LEFT"));
            else roads.add(new Road(0,i,Road.randomColor(),"RIGHT"));
        }
    }

    public void addRoad(Road r)
    {
        roads.add(r);
    }

    public ArrayList<Road> getRoads()
    {
        return roads;
    }

    public void generateCars()
    {
        for(Road r:roads) r.generateCars();
    }

    //removes cars once they move off the screen
    public void cleanUpEdges()
    {
        for(Road r:roads) r.cleanUpEdges();
    }

    public void draw(Graphics window) 
    {
        for(Road r:roads) r.draw(window);
    }



}
