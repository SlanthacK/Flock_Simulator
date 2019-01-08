package sample;

import java.util.*;
import sample.*;
import flockbase.*;

public class Bird_ThirtyEight extends flockbase.Bird{
  private Position pos;
  private Position target;
  private int isLeader = 0;
  private Flock f;
  private int velocity;
  public Bird_ThirtyEight() {}
  public void becomeLeader()
  {
    isLeader = 1;
  }
  public void retireLead()
  {
    isLeader = 0;
  }
  public int checkleader()
  {
    if(isLeader == 1)
    {
      return 1;
    }
    else
    {
      return 0;
    }
  }
  protected void updatePos()
  {
    ArrayList<Bird> myFlock = new ArrayList<Bird>();
		myFlock = getFlock().getBirds();
		Position currentPos = getPos();
		double x_displacement = 0, y_displacement = 0;
    double temp_x = 0, temp_y = 0;
    double distance = 0;
    int x = currentPos.getX();
    int y = currentPos.getY();
    if (isLeader == 0)
		{
      Position leader_pos = getFlock().getLeader().getPos();
      setTarget(leader_pos.getX(),leader_pos.getY());
    }
    int x_target = getTarget().getX();
    int y_target = getTarget().getY();
		distance = Math.pow(Math.pow(y_target-y,2)+Math.pow(x_target-x,2),0.5);
		if(distance==0)
    {
      distance = 10;
    }
		x_displacement = ((x_target-x)*getMaxSpeed())/distance;
		y_displacement = ((y_target-y)*getMaxSpeed())/distance;
		for(Bird b:myFlock)
		{
			temp_x = b.getPos().getX();
			temp_y = b.getPos().getY();
			distance = Math.pow(Math.pow(temp_x-x,2)+Math.pow(temp_y-y,2),0.5);
			if(distance<2*getMaxSpeed() && distance!=0)
			{
				x_displacement += ((x - temp_x)*getMaxSpeed())/distance;
				y_displacement += ((y - temp_y)*getMaxSpeed())/distance;
			}
		}
		setPos(x+(int)x_displacement, y+(int)y_displacement);
  }
}
