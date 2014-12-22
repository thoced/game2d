package bilou;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;

public class mainProgram {

	public static void main(String[] args) 
	{
		bilouFramework framework = new bilouFramework();
		// TODO Auto-generated method stub
		//Create the window
		RenderWindow window = new RenderWindow();
		
		window.create(new VideoMode(800, 600), "Hello JSFML!");

		//Limit the framerate
		window.setFramerateLimit(30);
		
		// contentload
		framework.LoadContent();

		//Main loop
		while(window.isOpen()) {
		    //Fill the window with red
		    window.clear(Color.RED);

		   
	        // update
	        framework.Update();
	        // draw
	        framework.Draw(window);
		    
	        window.display();

		    //Handle events
		    for(Event event : window.pollEvents()) 
		    {
		        if(event.type == Event.Type.CLOSED) 
		        {
		            //The user pressed the close button
		        	framework.ReleaseContent();
		            window.close();
		        }
		        
		        // catchevent
		        framework.CatchEvent(event);
		        
		       
		       
		    }
		}
	}

}
