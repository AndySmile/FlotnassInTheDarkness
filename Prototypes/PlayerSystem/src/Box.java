import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;


public class Box {
	private Vector2f position;
	private int collisionRadius;
	
	public Box(Vector2f pos, int colRad) {
		position = pos;
		collisionRadius = colRad;
	}

	public void render(Graphics pen) throws SlickException {
		
		pen.drawImage(SpriteCache.instanceOf().getSprite("box_closed.png"), position.x - 16, position.y - 16);
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