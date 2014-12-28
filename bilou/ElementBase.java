package bilou;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

public class ElementBase implements IGameBase 
{
	// variables
	private float x;
	private float y;
	private float width;
	private float height;
	
	// Vue
	private RectangleShape rectvue;
	
	public ElementBase()
	{
		rectvue = new RectangleShape();
	}
	
	public ElementBase(Vector2f dimension,Vector2f position)
	{
		x = position.x;
		y = position.y;
		width = dimension.x;
		height = dimension.y;
		
		rectvue = new RectangleShape(dimension);
		rectvue.setOrigin(dimension.x /2,dimension.y /2);
		rectvue.setPosition(position);
		
	}
	
	public ElementBase(float w,float h,float x,float y)
	{
		x = x;
		y = y;
		width = w;
		height = h;
		
		rectvue = new RectangleShape(new Vector2f(width,height));
		rectvue.setOrigin(width /2,height /2);
		rectvue.setPosition(new Vector2f(x,y));
		
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

	

	@Override
	public void Init(Framework parent) {
		// TODO Auto-generated method stub
		
	}
}
