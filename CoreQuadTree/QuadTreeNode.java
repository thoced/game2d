package CoreQuadTree;

import java.util.ArrayList;

import org.jsfml.graphics.FloatRect;

import bilou.IGameBase;

public class QuadTreeNode 
{
	// membre static LevelNodeMax
	public static int LevelNodeMax = 6;
	// bounds du noeud
	private FloatRect bounds;
	// liste des éléments présents dans le noeud
	private ArrayList<IGameBase> elements = null;
	// references vers les 4 sous noeuds
	private QuadTreeNode[] nodesFils;
	// node level (permet de déterminer la hauteur maximal de l'arbre
	private int levelNode;
	
	
	public QuadTreeNode(int level,FloatRect bounds)
	{
		// initialisation du levelNode
		levelNode = level;
		
		// creation du bounds
		this.bounds = bounds;  
		
		// si le levelNode est supérieur au max de la hauteur des noeuds fils, on return
		if(levelNode > QuadTreeNode.LevelNodeMax)
			return;
		
		// instantiation des nodes fils
		nodesFils = new QuadTreeNode[4];
		// initialisation
		// création des bounds des fils nodes
		FloatRect b1 =  new FloatRect(bounds.left,bounds.top,bounds.width/2,bounds.height/2);
		FloatRect b2 =  new FloatRect(bounds.left + bounds.width /2,bounds.top,bounds.width/2,bounds.height/2);
		FloatRect b3 =  new FloatRect(bounds.left,bounds.top + bounds.height / 2,bounds.width/2,bounds.height/2);
		FloatRect b4 =  new FloatRect(bounds.left + bounds.width /2,bounds.top + bounds.height /2,bounds.width/2,bounds.height/2);
		
		// instance des 4 nodes fils
		nodesFils[0] = new QuadTreeNode(levelNode + 1,b1);
		nodesFils[1] = new QuadTreeNode(levelNode + 1,b2);
		nodesFils[2] = new QuadTreeNode(levelNode + 1,b3);
		nodesFils[3] = new QuadTreeNode(levelNode + 1,b4);
		
	
	}
	
	public void InsertElement(IGameBase element)
	{
		
		
		
			// l'element est-il dans le bounds ?
			FloatRect result = bounds.intersection(element.GetGlobalBounds());
			if(result != null)
			{
				
				if(levelNode < QuadTreeNode.LevelNodeMax)
				{
					// on descend dans les noeuds fils
					nodesFils[0].InsertElement(element);
					nodesFils[1].InsertElement(element);
					nodesFils[2].InsertElement(element);
					nodesFils[3].InsertElement(element);
				}
				else
				{
					// si on a atteind le levelMax, on ajoute dans le noeud
					if(elements == null)
						elements = new ArrayList<IGameBase>();
					
					elements.add(element);
				}
			}
		
	}
	
	public ArrayList<IGameBase> GetElements(FloatRect zone)
	{
		ArrayList<IGameBase> ret1,ret2,ret3,ret4;
		// recherche des élements de façon récursive
		FloatRect result = this.bounds.intersection(zone);
		if(result != FloatRect.EMPTY)
		{
			// la zone est bien comprise dans le node, on descend jusqu'a ce que la listes des élements est null
			if(elements != null)
			{
				// on descend dans les 4 nodes fils
				
				ret1 = nodesFils[0].GetElements(zone);
				ret2 = nodesFils[1].GetElements(zone);
				ret3 = nodesFils[2].GetElements(zone);
				ret4 = nodesFils[3].GetElements(zone);
				
				ret1.addAll(ret2);
				ret1.addAll(ret3);
				ret1.addAll(ret4);
				
				return ret1;
			
				
			}
			else
			{
				return elements;
			}
		}
		
		return null;
	}

	public FloatRect getBounds() {
		return bounds;
	}

	public void setBounds(FloatRect bounds) {
		this.bounds = bounds;
	}
	
	
}
