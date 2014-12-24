package bilou;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

import CoreQuadTree.QuadTreeNode;
import structure.Iunitbase;
import structure.wall;

public class bilouFramework 
{
	// arrayUnits
	private ArrayList<IGameBase> arrayElements;
	// frameclock
	private Clock frameClock = new Clock();
	// Time
	private  Time totalTime;
	// Camera
	private Camera camera;
	// QuadTree
	private QuadTreeNode quadtree;
	
	public bilouFramework()
	{
		// camera
		camera = new Camera();
		// instance quadtree
		quadtree = new QuadTreeNode(1,new FloatRect(0,0,10000,10000));
		// arrayunits
		arrayElements = new ArrayList<IGameBase>();
	}
	
	public void Update()
	{
		Time deltaTime = frameClock.restart();
		// update camera
		camera.Update(deltaTime);
		
		for(IGameBase unit : arrayElements)
		{
			unit.Update(deltaTime);
		}
	}
	
	public void Draw(RenderWindow window)
	{
		window.setView(camera.getView());
		
		for(IGameBase unit : arrayElements)
		{
			unit.Draw(window);
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
		
		
		ElementBase element = new ElementBase(new Vector2f(64,64),new Vector2f(128,128));
		
		this.quadtree.InsertElement(element);
		
		arrayElements.add(element);
	}
	
	public void ReleaseContent()
	{
		
	}
}
