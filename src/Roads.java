import java.util.*;
import java.awt.*;
public class Roads {
    private ArrayList<Road> roads;
    private ArrayList<Integer> yPosWithoutRoad;

    public Roads()
    {
        roads=new ArrayList<Road>();
        yPosWithoutRoad=new ArrayList<Integer>();
        for(int i=0;i<=760;i+=40)
        {
            if((int)(Math.random()*5)<=2)
            {
                int rand=(int)(Math.random()*2);
                // if(rand==0) roads.add(new Road(0,i,Road.randomColor(),"LEFT")); 
                // else roads.add(new Road(0,i,Road.randomColor(),"RIGHT"));
                if(rand==0) roads.add(new Road(0,i,Color.GRAY,"LEFT")); 
                else roads.add(new Road(0,i,Color.GRAY,"RIGHT"));
            }
            else yPosWithoutRoad.add(i);
            
        }
        for(int i=0;i<roads.size()-1;i++)
        {
            Road roadOne=roads.get(i);
            Road roadTwo=roads.get(i+1);
            if(roadOne.getDrivingDirection().equals(roadTwo.getDrivingDirection()))
            {
                while(roadOne.getRoadSpeed()==roadTwo.getRoadSpeed()) roadTwo.setRoadSpeed(1+(int)(Math.random()*3));
            }
        }
    }

    public ArrayList<Integer> getyPosWithoutRoad()
    {
        return yPosWithoutRoad;
    }

    public void addRoad(Road r)
    {
        roads.add(r);
    }

    public ArrayList<Road> getRoads()
    {
        return roads;
    }
    // public void move(String direction)
    // {
    //     if(direction.equals("DOWN"))
    //     {
    //         roads.remove(roads.size()-1);
    //         for(int i=0;i<roads.size();i++)
    //         {
    //             Road r=roads.get(i);
    //             r.move("DOWN");
    //         }
    //         Road roadToAdd=new Road(0,0,Road.randomColor(),Road.randomDirection());
    //         roadToAdd.generateCars();
    //         roads.add(0,roadToAdd);
    //     }
    //     else if(direction.equals("UP"))
    //     {
    //         roads.remove(0);
    //         for(int i=0;i<roads.size();i++)
    //         {
    //             Road r=roads.get(i);
    //             r.move("UP");
    //         }
    //         Road roadToAdd=new Road(0,760,Road.randomColor(),Road.randomDirection());
    //         roadToAdd.generateCars();
    //         roads.add(roadToAdd);

    //     }
    // }

    public void generateCars()
    {
        for(int i=0;i<roads.size();i++)
        {
            Road r=roads.get(i);
            r.generateCars();
        }
    }

    public ArrayList<Road> getList() {
        return roads;
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
