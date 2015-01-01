package bilou;

import java.util.List;

import org.jsfml.graphics.Drawable;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.PrimitiveType;
import org.jsfml.graphics.RenderStates;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Texture;
import org.jsfml.graphics.Transform;
import org.jsfml.graphics.Transformable;
import org.jsfml.graphics.Vertex;
import org.jsfml.graphics.VertexArray;
import org.jsfml.system.Vector2f;

public  class DrawableMap implements Drawable, Transformable 
{

	private Texture textureTileSets;
	
	private VertexArray listVertex;
	
	private int width,height,wTile,hTile,margin,parcing;
	
	private List<Integer> map;
	
	public DrawableMap()
	{
		// initialisationdu vertexarray
		listVertex = new VertexArray(PrimitiveType.QUADS);
	}
	
	public void LoadMap(List<Integer> map,Texture text,int width,int height,int wTile,int hTile,int margin,int parcing)
	{
		this.textureTileSets = text;
		
		this.width = width;
		this.height = height;
		this.wTile = wTile;
		this.hTile = hTile;
		this.margin = margin;
		this.parcing = parcing;
		
		this.map = map;
		
		// creation des vertex
		this.createVertex();
		
	}
	
	private void createVertex()
	{
		Vertex v0 = new Vertex(new Vector2f(0,0));
		Vertex v1 = new Vertex(new Vector2f(1,0));
		Vertex v2 = new Vertex(new Vector2f(1,1));
		Vertex v3 = new Vertex(new Vector2f(0,1));
		
		listVertex.add(v0);
		listVertex.add(v1);
		listVertex.add(v2);
		listVertex.add(v3);
	}
	
	@Override
	public Transform getInverseTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector2f getOrigin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector2f getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getRotation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector2f getScale() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transform getTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(Vector2f arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(float arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotate(float arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scale(Vector2f arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scale(float arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrigin(Vector2f arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOrigin(float arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(Vector2f arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(float arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRotation(float arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScale(Vector2f arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScale(float arg0, float arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(RenderTarget arg0, RenderStates arg1) {
		// TODO Auto-generated method stub
		
	}

}
