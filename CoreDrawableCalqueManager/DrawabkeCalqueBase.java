package CoreDrawableCalqueManager;

import org.jsfml.graphics.RenderTexture;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Time;

// class de base pour les drawable calque, permet ainsi d'afficher différent calque, dynamique, static

public abstract class DrawabkeCalqueBase 
{
	// sprite du layer à afficher
		protected Sprite imageCalque;
		// nom du calque
		protected String name;
		
		// methode abstract d'affichage
		public abstract void Draw(RenderTexture render);
		//methode abstract du update
		public abstract void Update(Time deltaTime);
}
