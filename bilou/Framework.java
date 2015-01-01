package bilou;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.jsfml.graphics.BlendMode;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Shader;
import org.jsfml.graphics.ShaderSourceException;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.TextureCreationException;
import org.jsfml.graphics.Transform;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

import CoreQuadTree.QuadTreeNode;
import Loader.LoaderMap;
import Loader.LoaderTiled;
import Loader.LoaderTiledException;
import structure.Iunitbase;
import structure.wall;

public class Framework 
{
	// arrayUnits
	private ArrayList<IGameBase> arrayElements;
	// listes des élements à supprimer du framework
	private ArrayList<IGameBase> arrayDelete;
	// listes elements venant du quadtree
	private ArrayList<IGameBase> listeElements;
	// frameclock
	private Clock frameClock = new Clock();
	// Time
	private  Time totalTime;
	// RenderWindow JSFML (SFML)
	private RenderWindow window;
	// RenderTexture
	private RenderTexture renderText,renderText2,renderFinal;
	// Sprite posteffect
	private Sprite postEffect1,postEffect2,postEffectFinal;
	// RenderState
	private RenderStates rState;
	// Shader
	private Shader shader;
	// Camera
	private Camera camera;
	// QuadTree
	private QuadTreeNode quadtree;
	// Logo
	private Logo log;
	// LoaderMap
	private LoaderMap loader;
	// Lens
	private Lens lens;
	
	private robot rob;
	
	private DrawableMap dm;
	
	public Framework(RenderWindow w) throws TextureCreationException
	{
		// Window
		window = w;
		// RenderTexture 01
		renderText = new RenderTexture();
		renderText.create(window.getSize().x, window.getSize().y);
	//	renderText.setView(window.getView());
		// creation du postEffect Sprite
		postEffect1 = new Sprite(renderText.getTexture());
		
		// RenderTexture 02
		renderText2 = new RenderTexture();
		renderText2.create(window.getSize().x, window.getSize().y);
	//	renderText2.setView(window.getView());
		postEffect2 = new Sprite(renderText2.getTexture());
		
		// RenderFinal
		renderFinal = new RenderTexture();
		renderFinal.create(window.getSize().x, window.getSize().y);
	//	renderFinal.setView(window.getView());
		postEffectFinal = new Sprite(renderFinal.getTexture());
		
		// RenderState
		shader = new Shader();
		rState = new RenderStates(BlendMode.ADD);
		
		
		// camera
		camera = new Camera(window);
		// instance quadtree
		quadtree = new QuadTreeNode(1,new FloatRect(0,0,4096,4096));
		// arrayunits
		arrayElements = new ArrayList<IGameBase>();
		// arraydelete
		arrayDelete = new ArrayList<IGameBase>();
		//ListeElement
		listeElements = new ArrayList<IGameBase>();
		// (TEST) chargement d'un niveau
		loader = new LoaderMap();
		// Lens
		lens = new Lens();
		try 
		{
			lens.Init(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ShaderSourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rob = new robot();
		try {
			rob.Init(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ShaderSourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
		
		lens.Update(deltaTime);
		
		// suppression des élements
		arrayElements.removeAll(arrayDelete);
	}
	
	public void Draw(RenderWindow window)
	{
		window.setView(camera.getView());
		
		
		Vector2f  size = camera.getView().getSize();
		Vector2f centre = camera.getView().getCenter();
		Vector2f source = Vector2f.sub(centre, Vector2f.div(size,2));
		FloatRect zone = new FloatRect(source,size);
		
		// on récupère les élements visible 
		listeElements.clear();
		quadtree.GetElements(zone,listeElements);
		
		//System.out.println("nb : " + String.valueOf(listeElements.size()) + " zone : x: " + zone.left + " y: " + zone.top + " width: " + zone.width + " height:" + zone.height);
		
		// on efface le backbuffer
		renderText.clear(new Color(32,32,48));
		
		// RENDER 01
		// on dessine les élements
	/*	for(IGameBase e : listeElements)
		{
			e.Draw(renderText);
		}
		
		
		// on rend les élements
		renderText.display();
		
		// RENDER 02
		// on dessine la lumière dans le render 2
		renderText2.clear(new Color(0,0,0,0));
		lens.Draw(renderText2);
		renderText2.display();
		
		// RENDER FINAL
		// on fusionne les deux render 01 et 03
		renderFinal.clear(new Color(255,255,255,0));
		renderFinal.draw(postEffect1);
		renderFinal.draw(postEffect2,rState);
		renderFinal.display();
	*/
	
	//	renderText.setView(camera.getView());
	//	dm.draw(renderText, rState);
		
		
	//	renderFinal.draw(postEffect1);
		
			
		// drawdebug quadtree
		//quadtree.DrawDebugBounds(window);
		
		// backbuffer dans le frontbuffer
		//renderText.display();
		/*RenderStates rs = new RenderStates(this.camera.getView().getTransform());
		dm.draw(renderText,rState);
		renderText.display();
		*/
	//	RenderStates rs = new RenderStates(this.camera.getView().getTransform());
		
		window.clear(new Color(32,32,48));
		window.draw(dm);
		window.display();
		
	}
	
	public void CatchEvent(Event event)
	{
		//if(event.type == Event.Type.MOUSE_MOVED)return;
		
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
	
	public void DestroyGameBase(IGameBase base)
	{
		arrayDelete.add(base);
	}
	
	public void LoadContent()
	{
	
		ElementBase element = new ElementBase(new Vector2f(64,64),new Vector2f(128,128));
		ElementBase element2 = new ElementBase(new Vector2f(64,64),new Vector2f(192,128));
		ElementBase element3 = new ElementBase(new Vector2f(64,64),new Vector2f(2048,128));
		
		Random rand = new Random();
		
		/*for(int i=0;i<16;i++)
		{
			
			//ElementBase element4 = new ElementBase(new Vector2f(16,16),new Vector2f(rand.nextInt(4096),rand.nextInt(4096)));
			ElementBase element4 = new ElementBase(new Vector2f(8,8),new Vector2f(128 + i * 32,128 + i * 64));
			this.quadtree.InsertElement(element4);
		}*/
		//ElementBase element4 = new ElementBase(new Vector2f(16,256),new Vector2f(128,128));
		//this.quadtree.InsertElement(element4);
		
		
		//this.quadtree.InsertElement(element);
		//this.quadtree.InsertElement(element2);
		//this.quadtree.InsertElement(element3);
		
		//arrayElements.add(element);
		//arrayElements.add(element2);
		/*log = new Logo();
		log.Init(this);
		arrayElements.add(log);*/
		
		// chargement de la map
		loader.LoadContent();
		// chargement des élementsz
		//arrayElements.addAll(loader.getListElement());
		for(IGameBase a : loader.getListElement())
			this.quadtree.InsertElement(a);
		
		LoaderTiled tiled = new LoaderTiled();
		try 
		{
			tiled.Load(LoaderTiled.class.getResourceAsStream("/Maps/map.json"));
			
			dm = new DrawableMap();
			Texture text = new Texture();
			text.loadFromStream(LoaderTiled.class.getResourceAsStream("/Textures/tileset01.png"));
			
			dm.LoadMap(tiled.getDataMap(), text, tiled.getMapWidth(), tiled.getMapHeight(), tiled.getTileWidth(), tiled.getTileHeight(), tiled.getMargin(), tiled.getParcing());
			
		} catch (LoaderTiledException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tiled);
		
	//	arrayElements.add(lens);
		//arrayElements.add(rob);
	}
	
	public void ReleaseContent()
	{
		
	}
}
