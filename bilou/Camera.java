package bilou;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.View;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

public class Camera implements ICoreBase
{
	// View
	private View view;
	// Constante
	public static Vector2f Right = 	new Vector2f(1,0);
	public static Vector2f Left = 	new Vector2f(-1,0);
	public static Vector2f Up = 		new Vector2f(0,1);
	public static Vector2f Down = 	new Vector2f(0,0-1);
	public static Vector2f Zero = Vector2f.ZERO;
	// CurrentAdd
	private Vector2f currentAdd = Vector2f.ZERO;
	// Speed camera
	private float speed = 512.0f;
	// ZoomLevel camera
	private int zoomLevel = 0;
	
	
	public Camera()
	{
		view = new View();
	}
	
	public void Update(Time deltaTime) 
	{

		// Modification de la vue de la camera
		Vector2f newcenter = Vector2f.add(view.getCenter(), Vector2f.mul(currentAdd, speed * deltaTime.asSeconds()));
		view.setCenter(newcenter);
		
	
	}

	public void Draw(RenderWindow window) 
	{
		// TODO Auto-generated method stub

	}
	
	public View getView()
	{
		return view;
	}

	public void setView(View view)
	{
		this.view = view;
	}
	
	public void Move(Vector2f move)
	{
		currentAdd = move;
	}

	public void ZoomIn()
	{
		Vector2f size = view.getSize();
		size = Vector2f.div(size, 2);
		view.setSize(size);
		this.zoomLevel ++;
	}
	public void ZoomOut()
	{
		Vector2f size = view.getSize();
		size = Vector2f.mul(size, 2);
		view.setSize(size);
		this.zoomLevel ++;
	}

}
