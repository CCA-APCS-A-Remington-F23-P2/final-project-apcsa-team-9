import java.util.*;
import java.awt.*;
public class Roads {
    private ArrayList<Road> roads;
    private ArrayList<Integer> yPosWithoutRoad;
    private ArrayList<Integer> yPosWithRoad;

    public Roads()
    {
        roads=new ArrayList<Road>();
        yPosWithoutRoad=new ArrayList<Integer>();
        yPosWithRoad=new ArrayList<Integer>();
        for(int i=40;i<=680;i+=40)
        {
            if((int)(Math.random()*5)<=2)
            {
                int rand=(int)(Math.random()*2);
                if(rand==0) roads.add(new Road(0,i,Color.GRAY,"LEFT")); 
                else roads.add(new Road(0,i,Color.GRAY,"RIGHT"));
                yPosWithRoad.add(i);
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

    public void incRoadSpeed() {
        for (Road r : roads ) {
           for (Car c : r.getCars()) {
            c.setSpeed(1 + c.getSpeed());
           }
        }
    }

    public ArrayList<Integer> getyPosWithRoad()
    {
        return yPosWithRoad;
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

    public void move()
    {
        for(int i=0;i<roads.size();i++)
        {
            Road r=roads.get(i);
            r.move();
        }
    }



}
