package bilou;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

public interface ICoreBase 
{
	public abstract void Update(Time deltaTime);
	
	public abstract void Draw(RenderTexture render,RenderStates state);
	
	public abstract void LoadContent();
	
	public abstract void ReloadContent();
	
	public abstract void DeleteContent();
	
	public abstract void Init();
	
	public abstract void CatchEvent(Event e);
	
}
