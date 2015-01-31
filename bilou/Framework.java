package bilou;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

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
import org.jsfml.graphics.View;
import org.jsfml.system.Clock;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

import CoreBackground.BackgroundDrawable;
import CoreBackground.BackgroundDrawable.TypeBackground;
import CoreDrawableCalqueManager.DrawableCalque;
import CoreDrawableCalqueManager.DrawableCalqueBase;
import CoreDrawableCalqueManager.DrawableCalqueDynamic;
import CoreDrawableCalqueManager.DrawableCalqueManager;
import CoreManagerObstacle.ObstacleManager;
import CoreQuadTree.QuadTreeNode;
import CoreTexturesManager.TexturesManager;
import Entities.EntitiesManager;
import Loader.LoaderMap;
import Loader.LoaderTiled;
import Loader.LoaderTiledException;
import Loader.TiledLayerImages;
import Loader.TiledLayerObjects;
import Loader.TiledLayerTiles;
import Loader.TiledObjectBase;
import Loader.TiledObjectPolyline;
import Loader.TiledObjectRectangle;
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
	private RenderStates rStateBackground,rStateForeGround;
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
	// Manager d'Obstacle
	private ObstacleManager obstacleManager;
	// Textures manager
	private TexturesManager texturesManager;
	// Entities manager
	private EntitiesManager entitiesManager;
	// Calques Manager
	private DrawableCalqueManager calquesManager;
	// PhysicWorld
	private PhysicWorld physic;
	// Lens
	private Lens lens;
	
	private robot rob;
	
	private DrawableMap dm,dm2;
	
	private Texture charlie;
	
	private Sprite charlieSprite;
	
	// backgrond
	private BackgroundDrawable background;
	// fps
	private int fps = 0;
	private Time fpsTime = Time.ZERO;
	
	public Framework(RenderWindow w) throws TextureCreationException
	{
		// Window
		window = w;
		//physic
		physic = new PhysicWorld();
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
		rStateBackground = new RenderStates(BlendMode.NONE);
		rStateForeGround = new RenderStates(BlendMode.ADD);
		
		
		// camera
		camera = new Camera(renderText);
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
		// instance du manager d'obstacle;
		obstacleManager = new ObstacleManager();
		// instance de Textures Manager
		texturesManager = new TexturesManager();
		// instance du manager d'entitées
		entitiesManager = new EntitiesManager();
		// instance du calquesmanager
		calquesManager = new DrawableCalqueManager();
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
		
		// background
		background = new BackgroundDrawable(window.getView().getSize());
		
	}
	
	public void Update()
	{
		fps++;
		
		Time deltaTime = frameClock.restart();
		
		fpsTime = Time.add(fpsTime, deltaTime);
		
		if(fpsTime.asSeconds() > 1.0f)
		{
			System.out.println("fps : " + String.valueOf(fps));
			fps=0;
			fpsTime = Time.ZERO;
		}
		
		// update camera
		camera.update(deltaTime);
		
		
		/*for(IGameBase unit : arrayElements)
		{
			unit.Update(deltaTime);
		}
		
		lens.Update(deltaTime);
		*/
		
		
		// update du calquemanager
		calquesManager.update(deltaTime);
		
		// update du entities manager
		entitiesManager.update(deltaTime);
		
		// suppression des élements
		arrayElements.removeAll(arrayDelete);
		
		// update du physic
		physic.update(deltaTime);
		
		// update du Background
		background.update(deltaTime);
		
				
	}
	
	public void Draw(RenderWindow window)
	{
		
		
		FloatRect zone = Camera.GetBoundsVisible();

		// on efface le backbuffer
		renderText.clear(Color.TRANSPARENT);
	
		// background affichage
		/*renderText.setView(camera.getView());
	 	dm.draw(renderText,rStateBackground);
		renderText.display();
		*/
	
		renderText.setView(window.getDefaultView());
		renderText.draw(background);
		renderText.display();
		
		// appel a la methode draw de l'entites manager
		renderText.setView(camera.getView());
		entitiesManager.draw(renderText,rStateForeGround);
		renderText.display();
		
		// foreground affichage
		//renderText.setView(camera.getView());
		//dm2.draw(renderText,rStateForeGround);
		//renderText.display();
		
	//	RenderStates rs = new RenderStates(this.camera.getView().getTransform());
		
		// on affiche les drawable calques
		renderText.setView(camera.getView());
		calquesManager.draw(renderText,rStateForeGround);
		renderText.display();
		
		
		// charlie
		/*renderText.setView(camera.getView());
		renderText.draw(charlieSprite);
		renderText.display();*/
		
		
		// affichage dans la fenetre principale (écran)
		window.clear(new Color(3,32,48));
		
		// Affichage du Background qui ne bouge pas
		window.draw(postEffect1);
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
			if(event.asKeyEvent().key == Keyboard.Key.O)
			{
				camera.ZoomIn();
			}
			else if(event.asKeyEvent().key == Keyboard.Key.P)
			{
				camera.ZoomOut();
			}
			
			// changement de player
			if(event.asKeyEvent().key == Keyboard.Key.G)
			{
				entitiesManager.SwitchPlayer();
			}
		}
		
		// catch pour l'entities manager
				entitiesManager.catchEvent(event);
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
		
		
		
		// textures manager loadcontent
		texturesManager.loadContent();
		// entities manager loadcontent
		entitiesManager.loadContent();
		
		
		LoaderTiled tiled = new LoaderTiled();
		try 
		{
			// chargement de la map
			tiled.Load(LoaderTiled.class.getResourceAsStream("/Maps/map.json"));
			// création d'une texture (tileset)
			Texture text = new Texture();
			// chargement de la texture
			text.loadFromStream(LoaderTiled.class.getResourceAsStream("/Textures/tilesetblavier.png"));
			
			try 
			{
				// creation de la drawablemap (background)
				dm = new DrawableMap();
				// creation de la drawable map (foreground)
				dm2 = new DrawableMap();
				
			} catch (ShaderSourceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			// réception du layers background
			//TiledLayerTiles o = tiled.getListLayersTiles().get(0);
			//dm.LoadMap(o.getDataMap(), text, tiled.getMapWidth(), tiled.getMapHeight(), tiled.getTileWidth(), tiled.getTileHeight(), tiled.getMargin(), tiled.getParcing(),tiled.getFirstgid());
			
			// réception du layers foreground
			//TiledLayerTiles o2 = tiled.getListLayersTiles().get(1);
			//dm2.LoadMap(o2.getDataMap(), text, tiled.getMapWidth(), tiled.getMapHeight(), tiled.getTileWidth(), tiled.getTileHeight(), tiled.getMargin(), tiled.getParcing(),tiled.getFirstgid());
			
			// création du drawable calque manager
			for(TiledLayerImages calque : tiled.getListLayersImages())
			{
				// pour chaque calque on créer un drawablecalque
				String pathTexture = calque.getPathImage();
				// on récupère juste le nom de la texture
				//String[] nameTexture = pathTexture.split(File.separator);
				
				//JOptionPane.showConfirmDialog(null,pathTexture);
				
				String[] nameTexture  = null;
				
				String os = System.getProperty("os.name");
				
				
				if(os.equals("Linux"))
					nameTexture = pathTexture.split("/");
				else
					nameTexture = pathTexture.split("/");
				
				// on récupère la texture à partir du texturesmanager en y passant le dernier element du vecteur split
				String nameText = nameTexture[nameTexture.length-1];
				float posx = calque.getPosx();
				float posy = calque.getPosy();
				String nameCalque = calque.getName();
			
				// on ajoute dans le drawablemanager
				
				DrawableCalqueBase c = null;
				
				if(calque.getTypeCalque() == null)
				{
					// c'est un simple calque static
					Texture t = TexturesManager.GetTextureByName(nameText);
					c = new DrawableCalque(t, nameCalque, posx, posy);
				}
				else
				{
					if(calque.getTypeCalque().equals("dynamic"))
					{
						
						// on récupère les information dynamic
						float speed = calque.getSpeed();
						float targetX = calque.getTargetX();
						float targetY = calque.getTargetY();
						// c'est un calque dynamic
						Texture t = TexturesManager.GetTextureByName(nameText);
						c = new DrawableCalqueDynamic(t,nameCalque,posx,posy,speed,targetX,targetY);
					}
				}
				
				
				calquesManager.InsertCalque(c);
			}
			
			// reception des obstacle via les objet7
			TiledLayerObjects layerObject = tiled.getListLayersObjects().get(0);
			
			// chargement dans le manager d'obstacle
			if(layerObject != null)
			{
				// pour chaque objet dans le layer objects
				for(TiledObjectBase base : layerObject.getDataObjects())
				{
					
					if(base.getTypeObjects() == TiledObjectBase.Type.RECTANGLE)
					{
					// on ajoute les obstacle dans le m.anager d'obstacle
						TiledObjectRectangle r = (TiledObjectRectangle)base;
						obstacleManager.InsertObstacle(r.getX(),r.getY(), r.getWidth(), r.getHeight(),r.getType());
						
						
					}
					
					if(base.getTypeObjects() == TiledObjectBase.Type.POLYLINE)
					{
						// on ajoute un polyline comme obstacle
						TiledObjectPolyline p = (TiledObjectPolyline)base;
						
						obstacleManager.InsertObstacle(p.getListPoint(),p.getX(),p.getY(),p.getType());
						
					}
				}
			}
			
		} catch (LoaderTiledException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tiled);
		
		// Chargement du background
		background.ChooseBackground(TypeBackground.BACKGROUND01);
		
	//	arrayElements.add(lens);
		//arrayElements.add(rob);
	}
	
	public void ReleaseContent()
	{
		
	}
}
