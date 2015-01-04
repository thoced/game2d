package CoreManagerObstacle;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

import bilou.ICoreBase;

public class ObstacleManager extends ObstacleBase implements ICoreBase
{
	private int sizeofmemory = 16;
	// liste des obstacles
	private List<ObstacleBase> listeObstacle;
	
	public ObstacleManager()
	{
		// instance de la liste des obstacles
		listeObstacle = new ArrayList<ObstacleBase>(this.sizeofmemory);
	}

	@Override
	public ObstacleResult IsPointCollision(int x, int y)
	{
		// on test si le point est en collision avec un obstacle
		for(ObstacleBase obs : this.listeObstacle)
		{
			ObstacleResult result = obs.IsPointCollision(x, y);
			if(result !=null)
				return result;
		}
		
		return null;
	}

	@Override
	public ObstacleResult IsRectangleCollision(int x, int y, int width,
			int height) {
		
		// on test si le rectangle est en collision avec un obstacle
				for(ObstacleBase obs : this.listeObstacle)
				{
					ObstacleResult result = obs.IsRectangleCollision(x, y, width, height);
					if(result !=null)
						return result;
				}
		
		return null;
	}

	@Override
	public ObstacleResult IsLineCollision(int x1, int y1, int x2, int y2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void InsertObstacle(int x1,int x2, int width,int height)
	{
		// création de l'obstacle rectangle
		ObstacleRectangle rect = new ObstacleRectangle(x1,x2,width,height);
		
		// ajout dans la liste des obstacles
		this.listeObstacle.add(rect);
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
	public void Draw() {
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
	
	

	
	
	
}
