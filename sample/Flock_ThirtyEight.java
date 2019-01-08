package sample;

import java.util.*;
import sample.*;
import flockbase.*;

public class Flock_ThirtyEight extends flockbase.Flock{
  private ArrayList<Bird> myFlock = new ArrayList();
  private Bird flockLeader;
  public Flock_ThirtyEight() {}
  public void addBird(Bird b)
  {
    myFlock.add(b);
		b.setFlock(this);
  }
  public void setLeader(Bird leader)
  {
    if(flockLeader != null)
    {
      flockLeader.retireLead();
    }
		flockLeader = leader;
		leader.becomeLeader();
  }
  public ArrayList<Bird> getBirds()
  {
    return myFlock;
  }
  public Bird getLeader()
  {
    return flockLeader;
  }
  public Flock split(int pos)
	{
		Flock_ThirtyEight f = new Flock_ThirtyEight();
		f.setLeader(myFlock.get(pos));
		for(int i=pos;i<myFlock.size();i++)
		{
			f.addBird(myFlock.get(i));

		}
		for(int i=pos;i<myFlock.size();i=i)
		{
			myFlock.get(i).setFlock(f);
			myFlock.remove(i);
		}
		return f;
	}

	public void joinFlock(Flock f)
	{
		ArrayList<Bird> temp = new ArrayList<Bird>();
		Bird b1 = getLeader();
		b1.retireLead();
		temp = getBirds();
		for(Bird b:temp)
		{
			f.addBird(b);
			b.setFlock(f);
		}
	}
}
