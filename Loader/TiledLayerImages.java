package Loader;

import org.jsfml.graphics.Sprite;

public class TiledLayerImages 
{
	// nom du layer image
		private String name;
		
	// coordonnée d'affichage de l'image
		private int posx,posy;
		
	// taille de l'image
		private int width,height;
	
	// chemin absolu de l'image
		private String pathImage;
		
	// type de chemin
		private String type;

		/**
		 * @return the image
		 */
		

		/**
		 * @return the posx
		 */
		public int getPosx() {
			return posx;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @param posx the posx to set
		 */
		public void setPosx(int posx) {
			this.posx = posx;
		}

		/**
		 * @return the posy
		 */
		public int getPosy() {
			return posy;
		}

		/**
		 * @param posy the posy to set
		 */
		public void setPosy(int posy) {
			this.posy = posy;
		}

		/**
		 * @return the width
		 */
		public int getWidth() {
			return width;
		}

		/**
		 * @param width the width to set
		 */
		public void setWidth(int width) {
			this.width = width;
		}

		/**
		 * @return the height
		 */
		public int getHeight() {
			return height;
		}

		/**
		 * @param height the height to set
		 */
		public void setHeight(int height) {
			this.height = height;
		}

		/**
		 * @return the pathImage
		 */
		public String getPathImage() {
			return pathImage;
		}

		/**
		 * @param pathImage the pathImage to set
		 */
		public void setPathImage(String pathImage) {
			this.pathImage = pathImage;
		}

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}
		
		
}
