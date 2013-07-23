import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

public class TheGame extends BasicGame {

	private Player player;
	private LightHouse lightHouse;
	private TheDarkness darkness;
	
	private ArrayList<Box> boxes = new ArrayList<Box>();
	
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public Image water;
    
    public Shape s;
	
	public TheGame(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		SpriteCache.instanceOf().addResourceLocation("./sprites/");
		player = new Player(new Vector2f(10, 10), 16);
		lightHouse = new LightHouse(new Vector2f(WIDTH/2, HEIGHT/2), "lighthouse.png");
		darkness = new TheDarkness(WIDTH, HEIGHT);

		for(int i = 0; i < 10; i++) {
			Box box = new Box(
				new Vector2f(((float)Math.random() * (640 - 32))+32, (float)Math.random() * (640 - 32) + 32),
				30
			);
			boxes.add(box);
		}
		
		Player.setBoxes(boxes);
		
		water = SpriteCache.instanceOf().getSprite("water.png");
  	  
		s = null;
		float[] TowerPolygon = new float[]{0, 0,  850, 850, 400, 250};
		s = new Polygon (TowerPolygon);
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

		drawWater(pen);
	  
		for(Box b : boxes) {
			b.render(pen);
		}
		
		player.render(pen);
		
		lightHouse.render(pen);
		darkness.render(pen);

	}

    public void drawWater (Graphics g){
  	  for (int x = 0; x < WIDTH; x+= water.getWidth()){
  		  for (int y = 0; y < HEIGHT; y+= water.getHeight()){
  			  water.draw(x, y);
      	  } 
  	  }
    }
    
	public static void main ( String[] args ) throws SlickException {
		TheGame game = new TheGame("A Test");
		AppGameContainer container = new AppGameContainer(game, WIDTH, HEIGHT, false);
		container.start();
	}
}