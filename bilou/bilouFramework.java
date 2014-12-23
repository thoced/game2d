package bilou;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.window.Keyboard;
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
	// Camera
	private Camera camera;
	
	public bilouFramework()
	{
		// camera
		camera = new Camera();
		// arrayunits
		arrayUnits = new ArrayList<Iunitbase>();
	}
	
	public void Update()
	{
		Time deltaTime = frameClock.restart();
		// update camera
		camera.Update(deltaTime);
		
		for(Iunitbase unit : arrayUnits)
		{
			unit.update(deltaTime);
		}
	}
	
	public void Draw(RenderWindow window)
	{
		window.setView(camera.getView());
		
		for(Iunitbase unit : arrayUnits)
		{
			unit.draw(window);
		}
	}
	
	public void CatchEvent(Event event)
	{
		if(event.type == Event.Type.MOUSE_MOVED)
		{
			camera.Move(Camera.Zero);
			
			if(event.asMouseEvent().position.x > 1024-64)
				camera.Move(Camera.Right);
			else if(event.asMouseEvent().position.x < 64)
				camera.Move(Camera.Left);
			
			if(event.asMouseEvent().position.y > 768-64)
				camera.Move(Camera.Up);
			else if(event.asMouseEvent().position.y < 64)
				camera.Move(Camera.Down);

		}
		
		if(event.type == Event.Type.KEY_PRESSED)
		{
			if(event.asKeyEvent().key == Keyboard.Key.A)
			{
				camera.ZoomIn();
			}
			else if(event.asKeyEvent().key == Keyboard.Key.Z)
			{
				camera.ZoomOut();
			}
		}
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
