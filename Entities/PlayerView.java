package Entities;

import org.jsfml.graphics.Sprite;
import org.jsfml.system.Time;

public class PlayerView extends EntitieBase 
{
	private PlayerControl pControl;
	
	// class Sprite
	private Sprite spritePlayer;
	
	
	public PlayerView()
	{
		// attachement au model MVC
		pControl.Attach(this);
	
	}

	@Override
	public void Update(Time elapsedTime) 
	{
		// TODO Auto-generated method stub
		pControl.Update(elapsedTime);
	}

	@Override
	public void UpdateMVC() 
	{
		// appel callback venant du model mvc
		
	}

	@Override
	public void LoadContent() {
		// TODO Auto-generated method stub
		
	}
	
	
}
