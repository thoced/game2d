package Entities;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import bilou.ICoreBase;

public class EntitiesManager implements ICoreBase
{
	
	private PlayerView player;
	
	
	public EntitiesManager()
	{
		
	}
	@Override
	public void Update(Time deltaTime)
	{
		// TODO Auto-generated method stub
		player.Update(deltaTime);
	}

	

	@Override
	public void LoadContent() 
	{
		// TODO Auto-generated method stub
		//Load content du TextureManager
		player = new PlayerView();
		player.LoadContent();
		player.SetPosition(new Vector2f(10,0));
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
	@Override
	public void Draw(RenderTexture render, RenderStates state) 
	{
		
		render.draw(player.getSpritePlayer());
		
	}
	
}
