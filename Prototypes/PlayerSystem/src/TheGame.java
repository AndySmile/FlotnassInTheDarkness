import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class TheGame extends BasicGame {

	private Player player;
	
	private ArrayList<Box> boxes = new ArrayList<Box>();
	
	public TheGame(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
		player = new Player(new Vector2f(10, 10), new Image("./sprites/floatsam.png"), 30);
		
		for(int i = 0; i < 10; i++) {
			Box box = new Box(
					new Vector2f(((float)Math.random() * (640 - 32))+32, (float)Math.random() * (640 - 32) + 32),
							new Image("./sprites/box.png"),
							30
			);
			boxes.add(box);
		}
		
		Player.setBoxes(boxes);
		
	}

	private void handleInput(GameContainer gc) {
		Input i = gc.getInput();

		if(i.isKeyDown(Input.KEY_UP))
			player.setMoveY(-1);

		if(i.isKeyDown(Input.KEY_DOWN))
			player.setMoveY(1);
		
		if(i.isKeyDown(Input.KEY_LEFT))
			player.setMoveX(-1);
		
		if(i.isKeyDown(Input.KEY_RIGHT))
			player.setMoveX(1);
	}

	@Override
	public void update(GameContainer gc, int timeDelta) throws SlickException {
		handleInput(gc);
		player.update(gc, timeDelta);
	}
	
	@Override
	public void render(GameContainer gc, Graphics pen) throws SlickException {
		for(Box b : boxes) {
			b.render(pen);
		}
		
		player.render(pen);
	}
	
	public static void main ( String[] args ) throws SlickException {
		TheGame game = new TheGame("A Test");
		AppGameContainer container = new AppGameContainer(game, 640, 640, false);
		container.start();
	}
}