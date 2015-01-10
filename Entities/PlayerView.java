package Entities;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.Sprite;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

import CoreTexturesManager.TexturesManager;

public class PlayerView extends EntitieBase 
{
	private PlayerControl pControl;
	
	// class Sprite
	private Sprite spritePlayer;
	
	
	public PlayerView()
	{
		// instance du PlayerControl
		pControl = new PlayerControl();
		// attachement au model MVC
		pControl.Attach(this);
		
	
		
	
	}

	@Override
	public void Update(Time elapsedTime) 
	{
		// TODO Auto-generated method stub
		pControl.Update(elapsedTime);
	}

	@Override
	public void UpdateMVC() 
	{
		// appel callback venant du model mvc
		
		// on met à jour l'affichage du sprite
		Vector2f pos = new Vector2f(this.pControl.getBody().getPosition().x,this.pControl.getBody().getPosition().y);
		spritePlayer.setPosition(pos);
		
		
	}

	@Override
	public void LoadContent() 
	{
		// TODO Auto-generated method stub
		spritePlayer = new Sprite(TexturesManager.GetTextureByName("player"));
		spritePlayer.setTextureRect(new IntRect(0,0,64,64));
		
	}
	
	public void SetPosition(Vector2f pos)
	{
		this.pControl.setPositionPlayer(pos);
	}

	@Override
	public void SetEvent(Event e) 
	{
		// TODO Auto-generated method stub
		pControl.SetEvent(e);
	}

	/**
	 * @return the spritePlayer
	 */
	public Sprite getSpritePlayer() {
		return spritePlayer;
	}

	/**
	 * @param spritePlayer the spritePlayer to set
	 */
	public void setSpritePlayer(Sprite spritePlayer) {
		this.spritePlayer = spritePlayer;
	}
	
	

}
