package Loader;

import java.io.InputStream;
import java.util.ArrayList;
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
	// nom de la map
	private String nameMap;
	// data map
	private List<Integer> dataMap;
	
	public String toString()
	{
		return String.valueOf(mapWidth) + " , " + String.valueOf(mapHeight) + dataMap; 
	}
	
	public void Load(InputStream nameFile) throws LoaderTiledException
	{
		// si l'input stream est null, on lance l'exception
		if(nameFile==null)
			throw new LoaderTiledException();
		
		// ouverture du fichier
				JsonReader reader = Json.createReader(nameFile);
				if(reader==null)
					throw new LoaderTiledException();
				
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
				
				JsonArray  tilesets = obj.getJsonArray("tilesets");
				// on récupère la liste des objets contenu danas le tableau tilesets		
				List<JsonObject> l = tilesets.getValuesAs(JsonObject.class);
				
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
				// ---------------- obtention du tableau layers -------------
				// -----------------------------------------------------------
				// -----------------------------------------------------------
				
				JsonArray  layers = obj.getJsonArray("layers");
				// on récupère la liste des objets contenu danas le tableau layers		
				List<JsonObject> listLayers = layers.getValuesAs(JsonObject.class);
				
				// instance de data map
				dataMap = new ArrayList<Integer>();
				
				for(JsonObject o : listLayers)
				{
					if(o.containsKey("name"))
					{
						this.nameMap = o.getString("name");
					}
					
					if(o.containsKey("data"))
					{
						dataMap.clear();
						JsonArray data = o.getJsonArray("data");
						for(int ind=0;ind<data.size();ind++)
							dataMap.add(data.getInt(ind));
					}
				}
	}
	
	
	
	/**
						this.tileWidth = o.getInt("ti
	 * @return the mapWidth
	 */
	public int getMapWidth() {
		return mapWidth;
	}

	/**
	 * @param mapWidth the mapWidth to set
	 */
	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	/**
	 * @return the mapHeight
	 */
	public int getMapHeight() {
		return mapHeight;
	}

	/**
	 * @param mapHeight the mapHeight to set
	 */
	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the imageWidth
	 */
	public int getImageWidth() {
		return imageWidth;
	}

	/**
	 * @param imageWidth the imageWidth to set
	 */
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	/**
	 * @return the imageHeight
	 */
	public int getImageHeight() {
		return imageHeight;
	}

	/**
	 * @param imageHeight the imageHeight to set
	 */
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	/**
	 * @return the tileWidth
	 */
	public int getTileWidth() {
		return tileWidth;
	}

	/**
	 * @param tileWidth the tileWidth to set
	 */
	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	/**
	 * @return the tileHeight
	 */
	public int getTileHeight() {
		return tileHeight;
	}

	/**
	 * @param tileHeight the tileHeight to set
	 */
	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

	/**
	 * @return the margin
	 */
	public int getMargin() {
		return margin;
	}

	/**
	 * @param margin the margin to set
	 */
	public void setMargin(int margin) {
		this.margin = margin;
	}

	/**
	 * @return the spacing
	 */
	public int getSpacing() {
		return spacing;
	}

	/**
	 * @param spacing the spacing to set
	 */
	public void setSpacing(int spacing) {
		this.spacing = spacing;
	}

	/**
	 * @return the firstgid
	 */
	public int getFirstgid() {
		return firstgid;
	}

	/**
	 * @param firstgid the firstgid to set
	 */
	public void setFirstgid(int firstgid) {
		this.firstgid = firstgid;
	}

	/**
	 * @return the nameMap
	 */
	public String getNameMap() {
		return nameMap;
	}

	/**
	 * @param nameMap the nameMap to set
	 */
	public void setNameMap(String nameMap) {
		this.nameMap = nameMap;
	}

	/**
	 * @return the dataMap
	 */
	public List<Integer> getDataMap() {
		return dataMap;
	}

	/**
	 * @param dataMap the dataMap to set
	 */
	public void setDataMap(List<Integer> dataMap) {
		this.dataMap = dataMap;
	}

	public static void main(String[] args) 
	{
		
		LoaderTiled tiled = new LoaderTiled();
		try 
		{
			tiled.Load(LoaderTiled.class.getResourceAsStream("/Maps/map.json"));
			
		} catch (LoaderTiledException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tiled);
		
	
		
		
	}
		

}
