package CoreDrawableCalqueManager;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

import CoreTexturesManager.TexturesManager;
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
	
	public void InsertCalque(String pathTexture,String name,int posx,int posy)
	{
		// on récupère la texture via le textures manager
		Texture text = TexturesManager.GetTextureByName(pathTexture);
		
		// on créer un calque
		DrawableCalque calque = new DrawableCalque(text,name,posx,posy);
		
		// on ajoute dans la liste
		this.listCalques.add(calque);
		
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
