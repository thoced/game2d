package bilou;

import java.io.IOException;
import java.lang.reflect.Constructor;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.Transform;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

public class ElementBase implements IGameBase 
{
	// variables
	private float x;
	private float y;
	private float width;
	private float height;
	
	private Transform trans;
	
	// Vue
	private RectangleShape rectvue;
	
	// test texture
	private Texture text;
	
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
		rectvue.setOrigin(0,0);
		rectvue.setPosition(position);
		
	}
	
	public ElementBase(float w,float h,float x,float y)
	{
		x = x;
		y = y;
		width = w;
		height = h;
		
		rectvue = new RectangleShape(new Vector2f(width,height));
		rectvue.setOrigin(0,0);
		rectvue.setPosition(new Vector2f(x,y));
		rectvue.setOutlineColor(Color.RED);
		rectvue.setOutlineThickness(2.0f);
		

	}
	
	@Override
	public void Update(Time deltaTime) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Draw(RenderWindow window) 
	{
		
		//RenderStates state;
		// on applique la nouvelle matrice de transformation
		//state = new RenderStates(newTrans);
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

	public Transform getTrans() {
		return trans;
	}

	public void setTrans(Transform trans) {
		this.trans = trans;
		
	}
	
	
}
