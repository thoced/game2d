package Loader;

import java.util.List;

import javax.json.*;
import javax.json.JsonValue.ValueType;

public class LoaderTiled 
{
	// taille de la map
	private int mapWidth,mapHeight;
	// path de l'image du tileset
	private String image;
	// taille du tileset
	private int imageWidth,imageHeight;
	// taille des tiles
	private int tileWidth,tileHeight;
	// marge et spacing entre les tiles
	private int margin,spacing;
	// firstgid
	private int firstgid;
	
	
	public String toString()
	{
		return String.valueOf(mapWidth) + " , " + String.valueOf(mapHeight); 
	}
	
	public void Load()
	{
		// ouverture du fichier
				JsonReader reader = Json.createReader(LoaderTiled.class.getResourceAsStream("/Maps/map.json"));
				// lecture de l'objet principale json
				JsonObject obj = reader.readObject();
				
				// on récupère la taille de la map
				if(obj.containsKey("width"))
				{
					this.mapWidth = obj.getInt("width");
				}
				
				if(obj.containsKey("height"))
				{
					this.mapHeight = obj.getInt("height");
				}
				
				
				// ---------------- obtention du tableau tileset -------------
				// -----------------------------------------------------------
				// -----------------------------------------------------------
				
				JsonArray  layers = obj.getJsonArray("tilesets");
				// on récupère la liste des objets contenu danas le tableau layers		
				List<JsonObject> l = layers.getValuesAs(JsonObject.class);
				
				for(JsonObject o :  l)
				{
					// on récupère le path de l'image du tileset
					if(o.containsKey("image"))
					{
						this.image = o.getString("image");
					}
					
					if(o.containsKey("imagewidth"))
					{
						this.imageWidth = o.getInt("imagewidth");
					}
					
					if(o.containsKey("imageheight"))
					{
						this.imageHeight = o.getInt("imageheight");
					}
					if(o.containsKey("margin"))
					{
						this.margin = o.getInt("margin");
					}
					
					if(o.containsKey("spacing"))
					{
						this.spacing = o.getInt("spacing");
					}
					
					if(o.containsKey("tilewidth"))
					{
						this.tileWidth = o.getInt("tilewidth");
					}
					
					if(o.containsKey("tileheight"))
					{
						this.tileHeight = o.getInt("tileheight");
					}
					
					if(o.containsKey("firstgid"))
					{
						this.firstgid = o.getInt("firstgid");
					}
				}
				
				// ---------------------------------------------------------
				// ---------------------------------------------------------
				
				
	}
	
	public static void main(String[] args) 
	{
		
		LoaderTiled tiled = new LoaderTiled();
		tiled.Load();
		System.out.println(tiled);
		
	//	System.out.println(number);
		
		
	}
		

}
