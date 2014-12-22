package bilou;

import java.util.ArrayList;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

import structure.Iunitbase;
import structure.wall;

public class bilouFramework 
{
	// arrayUnits
	private ArrayList<Iunitbase> arrayUnits;
	// frameclock
	private Clock frameClock = new Clock();
	// Time
	private  Time totalTime;
	
	public bilouFramework()
	{
		arrayUnits = new ArrayList<Iunitbase>();
	}
	
	public void Update()
	{
		Time deltaTime = frameClock.restart();
		
		for(Iunitbase unit : arrayUnits)
		{
			unit.update(deltaTime);
		}
	}
	
	public void Draw(RenderWindow window)
	{
		for(Iunitbase unit : arrayUnits)
		{
			unit.draw(window);
		}
	}
	
	public void CatchEvent(Event event)
	{
		
	}
	
	public void LoadContent()
	{
		wall w = new wall(new FloatRect(0,0,200,200));
		arrayUnits.add(w);
	}
	
	public void ReleaseContent()
	{
		
	}
}
