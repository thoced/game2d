package Entities;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.MassData;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.dynamics.FixtureDef;
import org.jsfml.graphics.FloatRect;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Keyboard.Key;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;

import bilou.PhysicWorld;
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
	// est il sur le ground
	private boolean isground = false;
	// la touche space est elle enfoncée
	private boolean isSpace = false;
	
	// body physic
	private Body body;
	// bodydef
	private BodyDef bodyDef;
	
	private FixtureDef fixture;
	
	private Fixture ff;
	
	/**
	 * @return the isground
	 */
	public boolean isIsground() {
		return isground;
	}




	/**
	 * @param isground the isground to set
	 */
	public void setIsground(boolean isground) {
		this.isground = isground;
	}




	public PlayerControl()
	{
		// creatin du body jbox2d
		bodyDef = new BodyDef();
		bodyDef.position = new Vec2(1,0);
		bodyDef.type = BodyType.DYNAMIC;
		
		
		body = PhysicWorld.getWorldPhysic().createBody(bodyDef);
		body.setUserData(this);
		// initialisation du body
	
		//body.setFixedRotation(true);
		

		//
		fixture = new FixtureDef();
		PolygonShape poly = new PolygonShape();
		poly.setAsBox(1, 1);
		
		fixture.shape = poly;
		fixture.density = 1.0f;
		fixture.friction = 0.5f;
		fixture.restitution = 0.0f;
		
		ff = body.createFixture(fixture);
		

	
	}		
		
		
	
	
	@Override
	public void Update(Time elapsedTime) 
	{
		//if(!body.isAwake())
		//	this.setIsground(true);
		
		// on verifie l'etat du clavier
		if(   Keyboard.isKeyPressed(Keyboard.Key.D))
		{
			// si la touche D, la direction va vers la droite
			body.applyForce(new Vec2(256,0),body.getWorldCenter());
			
		
			
		}else if( Keyboard.isKeyPressed(Keyboard.Key.Q))
		{
			// si la touche Q, la direction va vers la gauche
			body.applyForce(new Vec2(-256,0),body.getWorldCenter());
		
		}
		
		if(!this.isSpace && this.isIsground() && Keyboard.isKeyPressed(Keyboard.Key.SPACE))
		{
			body.applyLinearImpulse(new Vec2(0,-72), body.getWorldCenter());
			this.setIsground(false);
			this.isSpace = true;
		}
		else if(!Keyboard.isKeyPressed(Keyboard.Key.SPACE))
			this.isSpace = false;
		
		
		
		// appel de l'appelMVC
		this.UpdateAttachMVC();
		
	}

	/**
	 * @return the body
	 */
	public Body getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(Body body) {
		this.body = body;
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
	public void setPositionPlayer(Vector2f positionPlayer) 
	{
		this.positionPlayer = positionPlayer;
		this.UpdateAttachMVC();
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
