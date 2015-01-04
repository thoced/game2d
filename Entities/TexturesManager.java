package Entities;

import java.io.IOException;
import java.util.Hashtable;

import org.jsfml.graphics.Texture;
import org.jsfml.graphics.TextureCreationException;
import org.jsfml.system.Time;
import org.jsfml.window.event.Event;

import bilou.ICoreBase;

public class TexturesManager implements ICoreBase
{
	// hash des textures
	private static Hashtable<String,Texture> hashTextures;
	// Texture blanck pour éviter le plantage
	private static Texture blankTexture = null;
	
	// manager - permet a la methode static d'appeller une methode de l'objet
	private static TexturesManager manager;
	
	
	public TexturesManager()
	{
		manager = this;
	}
	
	// methode static de récupération d'un objet texture sur base du nom
	public static Texture GetTextureByName(String name)
	{
		// la nom de la texture n'existe pas, on recharge la methode loadcontent
		if(!hashTextures.containsKey(name))
			manager.LoadContent();
		
		// si la texture n'existe toujours pas on retourne la texture blank
		if(!hashTextures.containsKey("player"))
			return blankTexture;
		
		return hashTextures.get(name);
	}
	
	
	
	@Override
	public void Update(Time deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void LoadContent() 
	{
		
		try
		{
			// chargement des texture
			if(blankTexture == null)
			{
				// création de la texture blank
				blankTexture = new Texture();
				blankTexture.create(32, 32);
				
			}
			
			// création de la texture players
			if(!hashTextures.containsKey("player")) // si celle-ci n'existe pas
			{
				Texture text01 = new Texture();
				text01.loadFromStream(TexturesManager.class.getResourceAsStream("/Textures/player.png"));
				// ajout dans le hash textures
				hashTextures.put("player", text01);
			}
			
		} catch (IOException | TextureCreationException e) {
			
			e.printStackTrace();
		}
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
