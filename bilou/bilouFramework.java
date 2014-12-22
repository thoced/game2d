package bilou;

import java.util.ArrayList;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

import structure.Iunitbase;
import structure.wall;

public class bilouFramework 
{
	// arrayUnits
	private ArrayList<Iunitbase> arrayUnits;
	
	public bilouFramework()
	{
		arrayUnits = new ArrayList<Iunitbase>();
	}
	
	public void Update()
	{
		
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
