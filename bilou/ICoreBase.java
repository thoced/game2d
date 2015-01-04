package bilou;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;

public interface ICoreBase 
{
	public abstract void Update(Time deltaTime);
	
	public abstract void Draw();
	
	public abstract void LoadContent();
	
	public abstract void ReloadContent();
	
	public abstract void DeleteContent();
	
	public abstract void Init();
	
}
