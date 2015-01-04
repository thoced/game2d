package Entities;

import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

import bilou.ICoreBase;

public class EntitiesManager implements ICoreBase
{
	// Player
	private PlayerView player;
	
	
	public EntitiesManager()
	{
		player = new PlayerView();
	}
	@Override
	public void Update(Time deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void LoadContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReloadContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CatchEvent(Event e) 
	{
		// TODO Auto-generated method stub
		this.player.SetEvent(e);
	}
	
}
