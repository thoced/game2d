package Loader;

import java.io.StringReader;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.json.stream.JsonParserFactory;

public class LoaderTiled {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		JsonParserFactory factory = Json.createParserFactory(null);
		JsonParser parser = factory.createParser(LoaderTiled.class.getResourceAsStream("/Maps/map.json"));

		while (parser.hasNext()) {
		  Event event = parser.next();

		  switch (event) {
		    case KEY_NAME: 
		    {
		      System.out.print(parser.getString() + "="); break;
		    }
		    case VALUE_NUMBER: 
		    {
		      System.out.println(parser.getInt()); break;
		    }
		  }
		}
		
	

	}

}
