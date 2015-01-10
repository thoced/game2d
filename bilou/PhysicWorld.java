package bilou;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;


public class PhysicWorld implements ICoreBase {

	// class world physic JBOX2D	 
	private static World worldPhysic;
	
	// gravity physic JBOX2D
	private static Vec2 gravity;
	
	private PhysicWorld pw;
	
	public PhysicWorld()
	{
		pw = this;
		// initilisation du gravity
		gravity = new Vec2(0,1024);
		// instance du world physis
		worldPhysic = new World(gravity);
	}
	
	
	/**
	 * @return the worldPhysic
	 */
	public static World getWorldPhysic() {
		return worldPhysic;
	}


	/**
	 * @param worldPhysic the worldPhysic to set
	 */
	public static void setWorldPhysic(World worldPhysic) {
		PhysicWorld.worldPhysic = worldPhysic;
	}


	@Override
	public void Update(Time deltaTime) 
	{
		// TODO Auto-generated method stub
		worldPhysic.step(deltaTime.asSeconds(), 6, 2);
	}

	@Override
	public void Draw(RenderTexture render, RenderStates state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void LoadContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ReloadContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CatchEvent(Event e) {
		// TODO Auto-generated method stub
		
	}

}
