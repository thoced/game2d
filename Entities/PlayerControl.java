package Entities;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.MassData;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jsfml.graphics.FloatRect;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Keyboard;
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
	// jump
	private Vector2f jump;
	
	// body physic
	private Body body;
	// bodydef
	private BodyDef bodyDef;
	
	public PlayerControl()
	{
		// creatin du body jbox2d
		bodyDef = new BodyDef();
		bodyDef.position = new Vec2(31,0);
		body = PhysicWorld.getWorldPhysic().createBody(bodyDef);
		
		// initialisation du body
		body.setActive(true);
		MassData md = new MassData();
		md.mass = 70.0f;
		body.setMassData(md);
		body.setBullet(false);
		body.setFixedRotation(true);
		body.setGravityScale(10.0f);
		body.setType(BodyType.DYNAMIC);
		//
		FixtureDef fixture = new FixtureDef();
		PolygonShape poly = new PolygonShape();
		poly.setAsBox(32, 32);
		Vec2[] vertices = poly.getVertices();
		fixture.shape = poly;
		fixture.density = 1.0f;
		fixture.friction = 1.0f;
		body.createFixture(fixture);
		body.synchronizeTransform();
	
	}		
		
		
	
	
	@Override
	public void Update(Time elapsedTime) 
	{
		// on verifie l'etat du clavier
		if(Keyboard.isKeyPressed(Keyboard.Key.D))
		{
			// si la touche D, la direction va vers la droite
			body.applyForceToCenter(new Vec2(128,0));
		}
		
		if(Keyboard.isKeyPressed(Keyboard.Key.Q))
		{
			// si la touche Q, la direction va vers la gauche
			direction = new Vector2f(-1,0);
		}
		
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
