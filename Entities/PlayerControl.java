package Entities;

import org.jsfml.system.Time;

public class PlayerControl extends EntitieBase 
{
	// class metier (controle MVC)
	
	@Override
	public void Update(Time elapsedTime) 
	{
		// appel callback
		this.UpdateAttachMVC();
	}

	@Override
	public void UpdateMVC() 
	{
		
		
	}

	@Override
	public void LoadContent() {
		// TODO Auto-generated method stub
		
	}
}
