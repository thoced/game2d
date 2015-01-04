package Entities;

import org.jsfml.system.Time;

public class PlayerView extends EntitieBase 
{
	private PlayerControl pControl;

	@Override
	public void Update(Time elapsedTime) 
	{
		// TODO Auto-generated method stub
		pControl.Update(elapsedTime);
	}
	
	
}
