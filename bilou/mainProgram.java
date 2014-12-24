package bilou;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
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
		
		window.create(new VideoMode(1024, 768), "Hello JSFML!");

		//Limit the framerate
		window.setFramerateLimit(30);
		
		bilouFramework framework = new bilouFramework(window);
		// contentload
		framework.LoadContent();

		//Main loop
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
			
		    //Fill the window with red
		    window.clear(Color.RED);
	        // update
	        framework.Update();
	        // draw
	        framework.Draw(window);
		    
	        window.display();
	        

		    
		}
	}

}
