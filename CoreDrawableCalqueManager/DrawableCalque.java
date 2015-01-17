package CoreDrawableCalqueManager;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;

import bilou.Camera;

public class DrawableCalque
{
	// sprite du layer à afficher
	private Sprite imageCalque;
	// nom du calque
	private String name;
	
	public DrawableCalque(Texture text,String name,int posx,int posy)
	{
		// creation du sprite depuis une reference texture
		imageCalque = new Sprite(text);
		// position du sprite
		imageCalque.setPosition(new Vector2f(posx,posy));
		// nom du calque
		this.name = name;
	}
	
	public void Draw(RenderTexture render)
	{
		// affichage du calque
		FloatRect result = Camera.GetBoundsVisible().intersection(this.imageCalque.getGlobalBounds());
		if(result!=null)
			render.draw(imageCalque);
		
	}
	
}