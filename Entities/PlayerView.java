package Entities;

import org.jsfml.graphics.Sprite;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

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
		spritePlayer.setPosition(this.pControl.getPositionPlayer());
		
		
	}

	@Override
	public void LoadContent() 
	{
		// TODO Auto-generated method stub
		spritePlayer = new Sprite(TexturesManager.GetTextureByName("player"));
		
		
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
	

}
