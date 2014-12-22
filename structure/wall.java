package structure;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2f;

public class wall implements Iunitbase
{
	private RectangleShape rect;
	
	public wall(FloatRect fr)
	{
		rect = new RectangleShape(new Vector2f(fr.width,fr.height));
		
		rect.setFillColor(Color.GREEN);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(RenderWindow window) {
		// TODO Auto-generated method stub
		window.draw(rect);
	}
	
	
	
}
