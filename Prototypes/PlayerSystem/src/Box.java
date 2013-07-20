import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;


public class Box {
	private Image sprite;
	private Vector2f position;
	private int collisionRadius;
	
	public Box(Vector2f pos, Image img, int colRad) {
		position = pos;
		sprite = img;
		collisionRadius = colRad;
	}

	public void render(Graphics pen) {
		pen.drawImage(sprite, position.x - 16, position.y - 16);
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public int getCollisionRadius() {
		return collisionRadius;
	}

	public void setCollisionRadius(int collisionRadius) {
		this.collisionRadius = collisionRadius;
	}

	public Item getItem() {
		return null;
		// TODO Auto-generated method stub
		
	}
}