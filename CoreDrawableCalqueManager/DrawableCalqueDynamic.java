package CoreDrawableCalqueManager;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderTexture;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2f;

import bilou.Camera;
import bilou.PhysicWorld;

public class DrawableCalqueDynamic extends DrawableCalqueBase 
{

	// vitesse de l'objet
	private float speed;
	// targetX et Y pour les destinations
	private float targetX,targetY;
	// Body
	private Body body;
	// vecteur target pour l'objet dynamique
	private Vec2 targetPos,initialPos;
	// boolean d'avance et recule
	private boolean istoTarget = true;
	
	public DrawableCalqueDynamic(Texture text, String name, float posx, float posy, float speed, float targetX,float targetY) 
	{
		// appel au constructeur de base pour les paramètres générique
		super(text, name, posx, posy);
		// vitesse
		this.speed = speed;
		// targetX et Y
		this.targetX = targetX;
		this.targetY = targetY;
		
		// creation de l'objet body jbox2d bodydef
		BodyDef bd = new BodyDef();
		bd.active = true; 
		bd.type = BodyType.KINEMATIC;
		bd.fixedRotation = true;
		bd.bullet = false;
				
		//  taille de l'image, il faut rapporter par le centre
		float tx = text.getSize().x;
		float ty = text.getSize().y;
		float halfX = tx / 2.0f;
		float halfY = ty / 2.0f;
		float nposx = posx + halfX;
		float nposy = posy + halfY;
		// on positionne l'objet body
		bd.position = new Vec2(nposx / PhysicWorld.getRatioPixelMeter(),nposy / PhysicWorld.getRatioPixelMeter());

		// creation du body
		body = PhysicWorld.getWorldPhysic().createBody(bd);
		
		// Shape
		PolygonShape poly = new PolygonShape();
		// création de la forme
		poly.setAsBox(halfX / PhysicWorld.getRatioPixelMeter(),halfY / PhysicWorld.getRatioPixelMeter());
		// création du fixture
		FixtureDef fd = new FixtureDef();
		fd.shape = poly;
		fd.density = 1.0f;
		fd.friction = 1.0f;
		fd.density = 1.0f;
		
		// on créer les vecteur initialPos et targetPos
		initialPos = body.getPosition().clone();
		// on détermine maintenant le sens de la platefo
				Vec2 vTarget = new Vec2(targetX,targetY);
				this.targetPos = body.getPosition().add(vTarget);
				vTarget.normalize();
				vTarget = vTarget.mul(this.speed);
				body.setLinearVelocity(vTarget);

		// create fixture
		body.createFixture(fd);
		// user date ground
		body.setUserData("ground"); // on force a ground pour pouvoir sauter sur les objets dynamiques
		//  setorigine sur l'imagecalque
		this.imageCalque.setOrigin(new Vector2f(halfX,halfY));
		
	}

	@Override
	public void Draw(RenderTexture render)
	{
		// TODO Auto-generated method stub
		// affichage du calque
	
			FloatRect result = Camera.GetBoundsVisible().intersection(this.imageCalque.getGlobalBounds());
			if(result!=null)
				render.draw(imageCalque);
	}

	@Override
	public void Update(Time deltaTime) 
	{
		// TODO Auto-generated method stub		
		
		// on vérifie que l'objet qui bouge n'est pas arrivé à destination
		Vec2 currentPos = body.getPosition();
		Vec2 diffEnd = targetPos.sub(currentPos);
		Vec2 diffStart = initialPos.sub(currentPos);
	
		if(istoTarget && diffEnd.length() <= 0.5f)
		{
			// on retourne le sens de la velocity
			body.setLinearVelocity(body.getLinearVelocity().negate());
			istoTarget = false;
		}
	    if(!istoTarget && diffStart.length() <= 0.5f)
		{
			body.setLinearVelocity(body.getLinearVelocity().negate());
			istoTarget = true;
		}
		
		// on récupère la position initial de l'objet
		
		// on créer la position d'affichage de l'objet image
		Vector2f newPos = new Vector2f(currentPos.x * PhysicWorld.getRatioPixelMeter(),currentPos.y * PhysicWorld.getRatioPixelMeter());
		// update de l'affichage
		imageCalque.setPosition(newPos);
		
		
	}

}
