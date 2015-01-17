package CoreDrawableCalqueManager;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

import bilou.Camera;
import bilou.ICoreBase;

public class DrawableCalqueManager implements ICoreBase
{
	// liste de Layers
	private List<DrawableCalque> listCalques;

	public DrawableCalqueManager()
	{
		// instance de la liste des calques
		this.listCalques = new ArrayList<DrawableCalque>();
	}
	
	@Override
	public void Update(Time deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Draw(RenderTexture render, RenderStates state) 
	{
		// TODO Auto-generated method stub
		
		for(DrawableCalque calque : this.listCalques)
		{
			// affichage des calques
			calque.Draw(render);
		}
		
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
