package Entities;

import org.jsfml.system.Time;

public abstract class EntitieBase extends ModelMVC
{
	public abstract void Update(Time elapsedTime);
	
	public abstract void LoadContent();

}
