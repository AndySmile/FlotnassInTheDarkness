import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Player {
	private Image sprite;
	private Vector2f position;
	private int direction;
	private int collisionRadius;
	
	private static ArrayList<Box> boxes;
	private ArrayList<Item> items;
	
	private int moveX, moveY;
	
	private int sanity = 100;

	public Player(Vector2f pos, Image img, int colRad) {
		position = pos;
		sprite = img;
		collisionRadius = colRad;
	}

	public void update(GameContainer gc, int timeDelta) {
        move();
        collideWithBox();
	}
	
	private void collideWithBox() 
	{
		if(this.boxes != null)
		{
			for(int i = 0; i < boxes.size(); i++) {
				if(position.distance(boxes.get(i).getPosition()) < collisionRadius)
					items.add(boxes.get(i).getItem());
					boxes.remove(i);
			}
		}
	}

	private void move() {
		position.x += moveX * 2;
        position.y += moveY * 2;
        moveX = 0;
        moveY = 0;		
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getCollisionRadius() {
		return collisionRadius;
	}

	public void setCollisionRadius(int collisionRadius) {
		this.collisionRadius = collisionRadius;
	}

	public int getMoveX() {
		return moveX;
	}

	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}

	public int getMoveY() {
		return moveY;
	}

	public void setMoveY(int moveY) {
		this.moveY = moveY;
	}

	public static ArrayList<Box> getBoxes() {
		return boxes;
	}

	public static void setBoxes(ArrayList<Box> boxes) {
		Player.boxes = boxes;
	}

	public int getSanity() {
		return sanity;
	}

	public void setSanity(int sanity) {
		this.sanity = sanity;
	}
}