package CoreBackground;

import java.awt.Window;

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Vector2f;

import bilou.Camera;
import CoreTexturesManager.TexturesManager;

public class BackgroundDrawable implements Drawable 
{
	// sprite du Background
	private Sprite spriteBackground = null;
	// enum des backgrounds
	public static enum TypeBackground {BACKGROUND01};
	@Override
	public void draw(RenderTarget render, RenderStates state) 
	{		
		render.draw(spriteBackground);
	}
	
	public void ChooseBackground(TypeBackground background)
	{
		switch(background)
		{
			case BACKGROUND01: spriteBackground = new Sprite(TexturesManager.GetTextureByName("background01.png"));
			break;
			
		}
		
		// on instancie si pas de fichier graphique trouvé
		if(spriteBackground == null)
			spriteBackground = new Sprite();
		// on place la position du background en 0.0
			spriteBackground.setPosition(new Vector2f(0f,0f));
	}

}
