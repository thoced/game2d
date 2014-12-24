package bilou;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;

public interface IGameBase 
{

	public abstract void Update(Time deltaTime);
	
	public abstract void Draw(RenderWindow window);
	
	public abstract FloatRect GetGlobalBounds();
	
	public abstract FloatRect GetLocalBounds();
}
