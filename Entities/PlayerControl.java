package Entities;

import org.jsfml.graphics.FloatRect;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;

import CoreManagerObstacle.ObstacleManager;
import CoreManagerObstacle.ObstacleResult;

public class PlayerControl extends EntitieBase 
{
	// class metier (controle MVC)
	// Vecteur de position
	private Vector2f positionPlayer;
	// bounds
	private FloatRect bounds;
	// Vecteur velocité
	private Vector2f velocity = Vector2f.ZERO;
	//  vitesse
	private float speed = 256.0f;
	// acceleration
	private float acceleration = 1.0f;
	// vecteur de direction
	private Vector2f direction = Vector2f.ZERO;
	// vecteur du jump
	private Vector2f jumpVector = new Vector2f(0,-1);
	// jump
	private Vector2f jump;
	// gravité
	private Vector2f gravityVector = new Vector2f(0,1);
	
	private Vector2f gravity;
	
	@Override
	public void Update(Time elapsedTime) 
	{
		// on verifie l'etat du clavier
		if(Keyboard.isKeyPressed(Keyboard.Key.D))
		{
			// si la touche D, la direction va vers la droite
			direction = new Vector2f(1,0);
		}
		
		if(Keyboard.isKeyPressed(Keyboard.Key.Q))
		{
			// si la touche Q, la direction va vers la gauche
			direction = new Vector2f(-1,0);
		}
		
		// 1) on détermine la direction emprunté par le player
		//  on détermine le vector velocity
		velocity = Vector2f.mul(direction,speed * elapsedTime.asSeconds());
		// on détermine le vecteur gravity
		gravity = Vector2f.mul(gravityVector, speed * elapsedTime.asSeconds());
		
		// 1) on test d'abord pour la gravity
		positionPlayer = Vector2f.add(positionPlayer,gravity);
		// 4) on test si la nouvelle position du player ne rentre pas en collision avec un obstacle
		ObstacleResult result = ObstacleManager.IsRectangleCollision((int)positionPlayer.x, (int)positionPlayer.y, 64, 64);
		// 5) si pas d'obstacle on appel la methode callback
		if(result == null)
			this.UpdateAttachMVC();
		else
		{
			positionPlayer = Vector2f.sub(positionPlayer, gravity);
			this.UpdateAttachMVC();

		}
		
		// 2) on test pour la velocity
		if(direction == Vector2f.ZERO)
			return;
		
		positionPlayer = Vector2f.add(positionPlayer, velocity);
		// 4) on test si la nouvelle position du player ne rentre pas en collision avec un obstacle
		ObstacleResult result2 = ObstacleManager.IsRectangleCollision((int)positionPlayer.x, (int)positionPlayer.y, 64, 64);
		// 5) si pas d'obstacle on appel la methode callback
		if(result2 == null)
			this.UpdateAttachMVC();
		else
		{
			positionPlayer = Vector2f.sub(positionPlayer, velocity);
			this.UpdateAttachMVC();

		}
		

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
		if(e.type == Event.Type.KEY_RELEASED)
		{
			direction = Vector2f.ZERO;
		}
	}
	
	
}
