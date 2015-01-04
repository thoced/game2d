package Entities;

import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;

public class PlayerControl extends EntitieBase 
{
	// class metier (controle MVC)
	// Vecteur de position
	private Vector2f positionPlayer;
	// Vecteur velocité
	private Vector2f velocity;
	//  vitesse
	private float speed;
	// acceleration
	private float acceleration;
	// vecteur de direction
	private Vector2f direction = Vector2f.ZERO;
	// gravité
	private Vector2f gravity;
	
	@Override
	public void Update(Time elapsedTime) 
	{
		// 1) on détermine la direction emprunté par le player
		// 2) on détermine le vector velocity
		
		// 3) on détermine la nouvelle position du player notamment en appliquant la gravity
		
		// 4) on test si la nouvelle position du player ne rentre pas en collision avec un obstacle
		
		// 5) si pas d'obstacle on appel la methode callback
		
		// 6) si obstacle on revient à la position initial
		
		// 7) appel callback pour appelé la View (MVC) afin d'afficher
		this.UpdateAttachMVC();
	}

	@Override
	public void UpdateMVC() 
	{
		
		
	}

	@Override
	public void LoadContent() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the positionPlayer
	 */
	public Vector2f getPositionPlayer() {
		return positionPlayer;
	}

	/**
	 * @param positionPlayer the positionPlayer to set
	 */
	public void setPositionPlayer(Vector2f positionPlayer) {
		this.positionPlayer = positionPlayer;
	}

	@Override
	public void SetEvent(Event e)
	{
		
		// TODO Auto-generated method stub
		
		if(e.type == Event.Type.KEY_PRESSED)
		{
		
		if(e.asKeyEvent().key == Keyboard.Key.D)
			{
				// si la touche D, la direction va vers la droite
				direction = new Vector2f(1,0);
			}
			
			if(e.asKeyEvent().key == Keyboard.Key.Q)
			{
				// si la touche Q, la direction va vers la gauche
				direction = new Vector2f(-1,0);
			}
		}
	}
	
	
}
