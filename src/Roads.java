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
    public void move(String direction)
    {
        if(direction.equals("DOWN"))
        {
            roads.remove(roads.size()-1);
            for(int i=0;i<roads.size();i++)
            {
                Road r=roads.get(i);
                r.move("DOWN");
            }
            roads.add(0,new Road(0,0,Road.randomColor(),Road.randomDirection()));
        }
        else if(direction.equals("UP"))
        {
            roads.remove(0);
            for(int i=0;i<roads.size();i++)
            {
                Road r=roads.get(i);
                r.move("UP");
            }
            roads.add(new Road(0,760,Road.randomColor(),Road.randomDirection()));

        }
    }

    public void generateCars()
    {
        for(int i=0;i<roads.size();i++)
        {
            Road r=roads.get(i);
            r.generateCars();
        }
    }

    //removes cars once they move off the screen
    public void cleanUpEdges()
    {
        for(int i=0;i<roads.size();i++)
        {
            Road r=roads.get(i);
            r.cleanUpEdges();
        }
    }

    public void draw(Graphics window) 
    {
        for(int i=0;i<roads.size();i++)
        {
            Road r=roads.get(i);
            r.draw(window);
        }
    }



}
