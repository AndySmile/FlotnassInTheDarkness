
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;


public class LightHouse {
	private static Shape collShape;
	private Vector2f position;
	private Image sprite;
	
    double iangle;
	
	public LightHouse(Vector2f pos, String spriteName) throws SlickException {
		sprite = SpriteCache.instanceOf().getSprite(spriteName);
		position = pos;
		
		collShape = new RoundedRectangle(position.x - sprite.getWidth()/2, position.y - sprite.getHeight()/2, sprite.getWidth(), sprite.getHeight(), 10);
		iangle = 0.0;
	}
	
	public void render(Graphics pen) throws SlickException {
		sprite.draw((position.x)-(sprite.getWidth()/2), (position.y)-(sprite.getHeight()/2));
				
		Image light = SpriteCache.instanceOf().getSprite("light.png");
		light.setAlpha((float) 0.7);
		 
		light.rotate((float) iangle);
		pen.drawImage(light, position.x - 590, position.y - 300);
		  
		iangle = 0.5;
		  
		Image img2 = SpriteCache.instanceOf().getSprite("lighthouse_top.png");
		img2.draw((position.x)-(img2.getWidth()/2), (position.y)-(img2.getHeight()/2));

	}

	public static Shape getCollShape() {
		return collShape;
	}

	public static void setCollShape(Shape collShape) {
		LightHouse.collShape = collShape;
	}

	public double getIangle() {
		return iangle;
	}

	public void setIangle(double iangle) {
		this.iangle = iangle;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
}