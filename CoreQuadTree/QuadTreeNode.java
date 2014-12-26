package CoreQuadTree;

import java.util.ArrayList;

import org.jsfml.graphics.FloatRect;

import bilou.IGameBase;

public class QuadTreeNode 
{
	// membre static LevelNodeMax
	public static int LevelNodeMax = 4;
	// nombre maximal d'éléments dans le node avant un split
	public static int NbMaxElement = 1;
	// bounds du noeud
	private FloatRect bounds;
	// liste des éléments présents dans le noeud
	private ArrayList<IGameBase> elements = null;
	// references vers les 4 sous noeuds
	private QuadTreeNode[] nodesFils;
	// node level (permet de déterminer la hauteur maximal de l'arbre
	private int levelNode;
	// le node est il splité ?
	private boolean iSSplited = false;

	
	
	public QuadTreeNode(int level,FloatRect bounds)
	{
		// initialisation du levelNode
		levelNode = level;
		// creation du bounds
		this.bounds = bounds;  
		// initialisation de elements
		this.elements = new ArrayList<IGameBase>();
		
	}
	
	public void Split()
	{
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
		
		// on récupére les élements et on les place dans les nodes fils
		
			for(IGameBase elem : this.elements)
			{
				nodesFils[0].InsertElement(elem);
				nodesFils[1].InsertElement(elem);
				nodesFils[2].InsertElement(elem);
				nodesFils[3].InsertElement(elem);
			}
		
	}
	
	public void InsertElement(IGameBase element)
	{
		
			// l'element est-il dans le bounds ?
			FloatRect result = bounds.intersection(element.GetGlobalBounds());
			if(result != null)
			{
				
				if(this.iSSplited) // c'est déja splité alors on insère dans les nodes fils
				{
					nodesFils[0].InsertElement(element);
					nodesFils[1].InsertElement(element);
					nodesFils[2].InsertElement(element);
					nodesFils[3].InsertElement(element);
				}
				else
				{
					// ce n'est pas encore splité
					if(this.elements.size() < this.NbMaxElement || this.levelNode > QuadTreeNode.LevelNodeMax)
					{
						elements.add(element);
					}
					else
					{
						// on split le node
						elements.add(element);
						// on crée les 4 fils nodes
						this.Split();
						// on true la variable ISSplited
						this.iSSplited = true;
						// on supprime les élements
						this.elements.clear();
					}
				}
				
				
			}
		
	}
	
	public void GetElements(FloatRect zone,ArrayList<IGameBase> listes)
	{
		// recherche des élements de façon récursive
		FloatRect result = this.bounds.intersection(zone);
		if(result != null)
		{
			
			if(!this.iSSplited)
			{
				listes.addAll(this.elements);
			}
			else
			{
				
					// on descend dans les 4 nodes fils
					
					nodesFils[0].GetElements(zone,listes);
					nodesFils[1].GetElements(zone,listes);
					nodesFils[2].GetElements(zone,listes);
					nodesFils[3].GetElements(zone,listes);
				
				
			}
			
		}
		
	}

	public FloatRect getBounds() {
		return bounds;
	}

	public void setBounds(FloatRect bounds) {
		this.bounds = bounds;
	}
	
	
}
