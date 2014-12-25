package bilou;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

public class ElementBase implements IGameBase 
{

	// Vue
	private RectangleShape rectvue;
	
	public ElementBase()
	{
		rectvue = new RectangleShape();
	}
	
	public ElementBase(Vector2f dimension,Vector2f position)
	{
		rectvue = new RectangleShape(dimension);
		rectvue.setOrigin(dimension.x /2,dimension.y /2);
		rectvue.setPosition(position);
		
	}
	
	@Override
	public void Update(Time deltaTime) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Draw(RenderWindow window) 
	{
		// TODO Auto-generated method stub
		window.draw(rectvue);

	}

	@Override
	public FloatRect GetGlobalBounds() 
	{
		// TODO Auto-generated method stub
		return rectvue.getGlobalBounds();
	}

	@Override
	public FloatRect GetLocalBounds()
	{
		// TODO Auto-generated method stub
		return rectvue.getLocalBounds();
	}
}
