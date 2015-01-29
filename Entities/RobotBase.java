package Entities;

import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

public class RobotBase extends EntitieBase 
{
	// est il sur le ground
	private boolean isground = false;
	
	@Override
	public void Update(Time elapsedTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void LoadContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void SetEvent(Event e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateMVC() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the isground
	 */
	public boolean isIsground() {
		return isground;
	}

	/**
	 * @param isground the isground to set
	 */
	public void setIsground(boolean isground) {
		this.isground = isground;
	}
	
	

}
