package CoreManagerObstacle;

import java.util.ArrayList;
import java.util.List;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

import bilou.ICoreBase;
import bilou.PhysicWorld;

public class ObstacleManager implements ICoreBase
{
	private int sizeofmemory = 16;
	// liste des obstacles
	private static List<ObstacleBase> listeObstacle;
	
	public ObstacleManager()
	{
		// instance de la liste des obstacles
		listeObstacle = new ArrayList<ObstacleBase>(this.sizeofmemory);
	}
	
	
	
	public static ObstacleResult IsPointCollision(int x, int y)
	{
		// on test si le point est en collision avec un obstacle
		for(ObstacleBase obs : listeObstacle)
		{
			ObstacleResult result = obs.IsPointCollision(x, y);
			if(result !=null)
				return result;
		}
		
		return null;
	}

	public  static ObstacleResult IsRectangleCollision(int x, int y, int width,
			int height) {
		
		// on test si le rectangle est en collision avec un obstacle
				for(ObstacleBase obs : listeObstacle)
				{
					ObstacleResult result = obs.IsRectangleCollision(x, y, width, height);
					if(result !=null)
						return result;
				}
		
		return null;
	}

	public static ObstacleResult IsLineCollision(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void InsertObstacle(int x ,int y , int width,int height)
	{
		// création de l'obstacle rectangle
		ObstacleRectangle rect = new ObstacleRectangle(x,y,width,height);
		
		// ajout dans la liste des obstacles
		this.listeObstacle.add(rect);
		
		// on ajoute dans le physic
		// pour le jbox2d
		// on défini la demi hauteur et la longueur du rectangle
		
		int halfW = width / 2;
		int halfH = height / 2;
		
		// on cree le body def
		BodyDef bDef = new BodyDef();
		bDef.position = new Vec2(x + halfW, y + halfH);
		bDef.bullet = false;
		bDef.type = BodyType.STATIC;
		
		// on cree le body
		Body bRect = PhysicWorld.getWorldPhysic().createBody(bDef);
		
		// creation de la fixture
		FixtureDef fixture = new FixtureDef();
		// creation du shape
		PolygonShape polygon = new PolygonShape();
		polygon.setAsBox(halfW, halfH);
		// attach a la fixture
		fixture.shape = polygon;
		// creation du fixutre
		bRect.createFixture(fixture);
		
		
		
	}
	public void Clear()
	{
		// Effacement des l'ensemble des obstacles
		this.listeObstacle.clear();
	}

	@Override
	public void Update(Time deltaTime) {
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
	public void CatchEvent(Event e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Draw(RenderTexture render, RenderStates state) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
	
}
