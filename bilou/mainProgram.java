package bilou;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.TextureCreationException;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.KeyEvent;

public class mainProgram {

	public static void main(String[] args) 
	{
		
		// TODO Auto-generated method stub
		//Create the window
		RenderWindow window = new RenderWindow();
		
		window.create(new VideoMode(1360, 768), "THOCED FrameWork (Test QuadTree)");

		//Limit the framerate
		window.setFramerateLimit(60);
		
		Framework framework = null;
		try 
		{
			framework = new Framework(window);
			// contentload
			framework.LoadContent();

			//Main loop
			
		} catch (TextureCreationException e) {
			// TODO Auto-generated catch block
			window.close();
			e.printStackTrace();
		}
		
		while(window.isOpen()) 
		{
			//Handle events
		    for(Event event : window.pollEvents()) 
		    {
	
		        if(event.type == Event.Type.CLOSED) 
		        {
		            //The user pressed the close button
		        	framework.ReleaseContent();
		            window.close();
		        }
		        
		     if(event.type == Event.Type.KEY_PRESSED)
		     {
		    	if(event.asKeyEvent().key == Keyboard.Key.ESCAPE)	
		    	{
		    		framework.ReleaseContent();
		            window.close();
		        }
		        
		     }
		    	  
		        // catchevent
		        framework.CatchEvent(event);  
		    }
			
		 
	        // update
	        framework.Update();
	        // draw
	        framework.Draw(window);
	       
	      
	        

		    
		}
	}

}
