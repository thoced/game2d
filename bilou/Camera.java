package bilou;

import javax.xml.parsers.DocumentBuilderFactory;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.View;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;
import org.jsfml.window.event.Event;

public class Camera implements ICoreBase
{
	// View
	private View view;
	// Constante
	public static Vector2f Right = 	new Vector2f(1,0);
	public static Vector2f Left = 	new Vector2f(-1,0);
	public static Vector2f Up = 	new Vector2f(0,1);
	public static Vector2f Down = 	new Vector2f(0,-1);
	public static Vector2f Zero = Vector2f.ZERO;
	// CurrentAdd
	private Vector2f currentAdd = Vector2f.ZERO;
	// Speed camera
	private float speed = 512.0f;
	// ZoomLevel camera
	private int zoomLevel = 1;
   

//Fill the win = 0;
	
	
	public Camera(RenderTexture window)
	{
		view = (View) window.getView();
		//view = new View();
	}
	
	public void Update(Time deltaTime) 
	{

		// Modification de la vue de la camera
		Vector2f newcenter = Vector2f.add(view.getCenter(), Vector2f.mul(currentAdd, speed * deltaTime.asSeconds()));
		view.setCenter(newcenter);
		
		
	}
    

//Fill the win
	
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


//Fill the win
	public void ZoomIn()
	{
		Vector2f size = view.getSize();
		size = Vector2f.div(size, 2);
		//view.setSize(size);
		view.zoom(2);
		this.zoomLevel ++;
	}
	public void ZoomOut()
	{
		Vector2f size = view.getSize();
		size = Vector2f.mul(size, 2);
		//view.setSize(size);
		view.zoom(0.5f);
		this.zoomLevel --;
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

	@Override
	public void Draw(RenderTexture render, RenderStates state) {
		// TODO Auto-generated method stub
		
	}

}
