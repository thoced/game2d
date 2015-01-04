package CoreManagerObstacle;

import java.util.ArrayList;
import java.util.List;

public class ObstacleManager extends ObstacleBase
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
	
	

	
	
	
}
