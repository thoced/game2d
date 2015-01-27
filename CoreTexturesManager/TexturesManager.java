package CoreTexturesManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Hashtable;

import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTexture;
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
		// instance du hashtextures
		hashTextures = new Hashtable<String,Texture>();
		
		manager = this;
	}
	
	// methode static de récupération d'un objet texture sur base du nom
	public static Texture GetTextureByName(String name)
	{
		// le nom de la texture n'existe pas, on la charge
		if(!hashTextures.containsKey(name))
			manager.LoadTexture(name);
		
		// la nom de la texture n'existe pas, on recharge la methode loadcontent
		if(!hashTextures.containsKey(name))
			manager.LoadContent();
		
		// si la texture n'existe toujours pas on retourne la texture blank
		if(!hashTextures.containsKey(name))
			return blankTexture;
		
		return hashTextures.get(name);
	}
	
	
	
	private void LoadTexture(String name) 
	{
		// TODO Auto-generated method stub
		try 
		{
			Texture text = new Texture();
			text.loadFromStream(TexturesManager.class.getResourceAsStream("/Textures/" + name));
			hashTextures.put(name, text);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Update(Time deltaTime) {
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
				text01.loadFromStream(TexturesManager.class.getResourceAsStream("/Textures/robotcarrepng.png"));
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

	@Override
	public void Draw(RenderTexture render, RenderStates state) {
		// TODO Auto-generated method stub
		
	}

}
