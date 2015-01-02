package Loader;

import java.util.ArrayList;
import java.util.List;

public class TiledObjectPolyline extends TiledObjectBase 
{
	// liste des points formant le polyline
	private List<TiledObjectPolylinePoint> listPoint;
	
	public TiledObjectPolyline()
	{
		this.setTypeObjects(Type.POLYLINE);
		// instance de la list
		listPoint = new ArrayList<TiledObjectPolylinePoint>();
	}
	
	public TiledObjectPolyline(Type t)
	{
		super(t);
		// instance de la list
		listPoint = new ArrayList<TiledObjectPolylinePoint>();
	}
	
	public void InsertPoint(int x,int y)
	{
		// on instantie un point
		TiledObjectPolylinePoint p = new TiledObjectPolylinePoint(x,y);
		// on ajoute dans la liste des points
		listPoint.add(p);
		
	}
}
