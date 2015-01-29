package Entities;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import bilou.ICoreBase;

public class EntitiesManager implements ICoreBase
{
	
	private SmallRobotView playerSmallRobot;
	
	
	
	public EntitiesManager()
	{
		
	}
	@Override
	public void Update(Time deltaTime)
	{
		// TODO Auto-generated method stub
		playerSmallRobot.Update(deltaTime);
	}

	

	@Override
	public void LoadContent() 
	{
		// TODO Auto-generated method stub
		//Load content du TextureManager
		playerSmallRobot = new SmallRobotView();
		playerSmallRobot.LoadContent();
		playerSmallRobot.SetPosition(new Vector2f(10,0));
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
		this.playerSmallRobot.SetEvent(e);
	}
	@Override
	public void Draw(RenderTexture render, RenderStates state) 
	{
		
		render.draw(playerSmallRobot.getSpritePlayer());
		
	}
	
}
