package bilou;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

import CoreQuadTree.QuadTreeNode;
import structure.Iunitbase;
import structure.wall;

public class bilouFramework 
{
	// arrayUnits
	private ArrayList<IGameBase> arrayElements;
	// listes elements venant du quadtree
	private ArrayList<IGameBase> listeElements;
	// frameclock
	private Clock frameClock = new Clock();
	// Time
	private  Time totalTime;
	// RenderWindow JSFML (SFML)
	private RenderWindow window;
	// Camera
	private Camera camera;
	// QuadTree
	private QuadTreeNode quadtree;
	
	public bilouFramework(RenderWindow w)
	{
		// Window
		window = w;
		// camera
		camera = new Camera(window);
		// instance quadtree
		quadtree = new QuadTreeNode(1,new FloatRect(0,0,5120,5120));
		// arrayunits
		arrayElements = new ArrayList<IGameBase>();
		//ListeElement
		listeElements = new ArrayList<IGameBase>();
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
		
		/*for(IGameBase unit : arrayElements)
		{
			unit.Draw(window);
		}*/
		Vector2f  size = camera.getView().getSize();
		Vector2f centre = camera.getView().getCenter();
		Vector2f source = Vector2f.sub(centre, Vector2f.div(size,2));
		FloatRect zone = new FloatRect(source,size);
		
		// on récupère les élements visible 
		listeElements.clear();
		quadtree.GetElements(zone,listeElements);
		
		System.out.println("nb : " + String.valueOf(listeElements.size()) + " zone : x: " + zone.left + " y: " + zone.top + " width: " + zone.width + " height:" + zone.height);
		
		for(IGameBase e : listeElements)
		{
			e.Draw(window);
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
		ElementBase element2 = new ElementBase(new Vector2f(64,64),new Vector2f(192,128));
		ElementBase element3 = new ElementBase(new Vector2f(64,64),new Vector2f(2048,128));
		
		for(int i=0;i<4;i++)
		{
			ElementBase element4 = new ElementBase(new Vector2f(64,64),new Vector2f(128 + i * 128,128 + i * 128));
			this.quadtree.InsertElement(element4);
		}
		
		//this.quadtree.InsertElement(element);
		//this.quadtree.InsertElement(element2);
		//this.quadtree.InsertElement(element3);
		
		//arrayElements.add(element);
		//arrayElements.add(element2);
	}
	
	public void ReleaseContent()
	{
		
	}
}
