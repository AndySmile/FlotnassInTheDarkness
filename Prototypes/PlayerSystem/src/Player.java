import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class Player {
	private Vector2f position;
	private int direction;
	private int collisionRadius;
	
	private Animation swimLeftAnim;
	
	private static ArrayList<Box> boxes;
	private ArrayList<Item> items;
	
	private int moveX, moveY, lastMoveX;
	
	private int sanity = 100;
	private Animation swimRightAnim;
	
	boolean blocked;

	public Player(Vector2f pos, int colRad) throws SlickException {
		position = pos;
		collisionRadius = colRad;
		
		swimLeftAnim = new Animation(true);
		swimLeftAnim.addFrame(SpriteCache.instanceOf().getSprite("player_left_1.png"), 100);
		swimLeftAnim.addFrame(SpriteCache.instanceOf().getSprite("player_left_2.png"), 100);
		swimLeftAnim.addFrame(SpriteCache.instanceOf().getSprite("player_left_3.png"), 100);
		
		swimRightAnim = new Animation(true);
		swimRightAnim.addFrame(SpriteCache.instanceOf().getSprite("player_right_1.png"), 100);
		swimRightAnim.addFrame(SpriteCache.instanceOf().getSprite("player_right_2.png"), 100);
		swimRightAnim.addFrame(SpriteCache.instanceOf().getSprite("player_right_3.png"), 100);
	}

	public void update(GameContainer gc, int timeDelta) {
		
		// animate movement
		if(moveX != 0 || moveY != 0) {
			swimLeftAnim.start();
			swimRightAnim.start();
		} else {
			swimRightAnim.stop();
			swimLeftAnim.stop();
		}
	
		// remember last direction
		if(moveX != 0)
			lastMoveX = moveX;
		
		// test collision with lighthouse
		if(LightHouse.getCollShape().intersects(new Circle(position.x, position.y, collisionRadius)))
			blocked = true;
		
		boolean inTheLight = false;
		for(Shape light : TheDarkness.getLights()) {
			if(light.contains(new Circle(position.x, position.y, collisionRadius))) {
				System.err.println("in the light");
				inTheLight = true;
				break;
			}
		}
		
		if(inTheLight && sanity < 100)
			sanity++;
		
		if(!inTheLight && sanity > 0)
			sanity--;
		
		if(!blocked)
			move();
		
        moveX = 0;
        moveY = 0;
		
        collideWithBox();
	}
	
	private void collideWithBox() {
		for(int i = 0; i < boxes.size(); i++) {
			if(position.distance(boxes.get(i).getPosition()) < collisionRadius + 16) {
//				items.add(boxes.get(i).getItem());
				boxes.remove(i);
			}
		}
	}

	private void move() {        
		position.x += moveX * 2;
        position.y += moveY * 2;
	}

	public void render(Graphics pen) throws SlickException {
			
		if(lastMoveX == -1) {
			swimLeftAnim.draw(position.x - 16, position.y - 16);
		}
		
		if(lastMoveX == 1) {
			swimRightAnim.draw(position.x - 16, position.y - 16);
		}
		
		pen.drawString(String.valueOf(sanity), TheGame.WIDTH - 100, 0);
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

	public int getLastMoveX() {
		return lastMoveX;
	}

	public void setLastMoveX(int lastMoveX) {
		this.lastMoveX = lastMoveX;
	}
}