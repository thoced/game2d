package Loader;

import org.jsfml.graphics.Sprite;

public class TiledLayerImages 
{
	// nom du layer image
		private String name = null;
		
	// coordonnée d'affichage de l'image
		private int posx,posy;
		
	// taille de l'image
		private int width,height;
	
	// chemin absolu de l'image
		private String pathImage = null;
		
	// type 
		private String type = null;
		
	// typeCalque
		private String typeCalque = null;
		
	// targetX et targetY (pour les déplacements dynamiques)
		private float targetX,targetY;
		
	// speed
		private float speed;  // m/s

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
		 * @return the typeCalque
		 */
		public String getTypeCalque() {
			return typeCalque;
		}

		/**
		 * @param typeCalque the typeCalque to set
		 */
		public void setTypeCalque(String typeCalque) {
			this.typeCalque = typeCalque;
		}

		/**
		 * @return the speed
		 */
		public float getSpeed() {
			return speed;
		}

		/**
		 * @param speed the speed to set
		 */
		public void setSpeed(float speed) {
			this.speed = speed;
		}

		/**
		 * @return the targetX
		 */
		public float getTargetX() {
			return targetX;
		}

		/**
		 * @param targetX the targetX to set
		 */
		public void setTargetX(float targetX) {
			this.targetX = targetX;
		}

		/**
		 * @return the targetY
		 */
		public float getTargetY() {
			return targetY;
		}

		/**
		 * @param targetY the targetY to set
		 */
		public void setTargetY(float targetY) {
			this.targetY = targetY;
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
