import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;

public class TheGame extends BasicGame {

	private Player player;
	
	private ArrayList<Box> boxes = new ArrayList<Box>();
	
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public Image waterG;
    public Image water;
    private TiledMap map;
    double iangle;
    
    public Shape s;
	
	public TheGame(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		SpriteCache.instanceOf().addResourceLocation("./sprites/");
		player = new Player(new Vector2f(10, 10), 30);

		for(int i = 0; i < 10; i++) {
			Box box = new Box(
				new Vector2f(((float)Math.random() * (640 - 32))+32, (float)Math.random() * (640 - 32) + 32),
				30
			);
			boxes.add(box);
		}
		
		Player.setBoxes(boxes);
		
  	  water = SpriteCache.instanceOf().getSprite("water.png");
  	  waterG = new Image (WIDTH, HEIGHT);
//  	  map = new TiledMap("map/map1.tmx");
  	  iangle = 0.0;
  	  
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
		
        Input input = gc.getInput();

	}
	
	@Override
	public void render(GameContainer gc, Graphics pen) throws SlickException {

		
		
  	  drawWater(pen);
  	  letThereBeDarkness(pen);
  	  // Draw Lighthouse
  	  Image img = SpriteCache.instanceOf().getSprite("lighthouse.png");
  	  img.draw((WIDTH/2)-(img.getWidth()/2), (HEIGHT/2)-(img.getHeight()/2));
  	  drawLightTowerLight(pen);
  	  Image img2 = SpriteCache.instanceOf().getSprite("lighthouse_top.png");
  	  img2.draw((WIDTH/2)-(img2.getWidth()/2), (HEIGHT/2)-(img2.getHeight()/2));
  	  
		for(Box b : boxes) {
			b.render(pen);
		}
		
		player.render(pen);

	}
	
    public boolean isInTheLight (Graphics g){
  	  
   	 
  	  g.setColor(Color.white);
  	  Transform t = new Transform(Transform.createRotateTransform((float) iangle));
  	  s = s.transform(t);
  	  g.translate(400, 300);

  	  g.fill(s);
  	  
  	  
  	  return false;
    }
	
    /**
     * Draws ambient light (dark).
     * @param g
     */
    public void letThereBeDarkness (Graphics g){
		  g.setColor(new Color(30,30,60, 200));
  	  g.fillRect(0, 0, WIDTH, HEIGHT);
	  }
	  
    
    public void drawWater (Graphics g){
  	  for (int x = 0; x < WIDTH; x+= water.getWidth()){
  		  for (int y = 0; y < HEIGHT; y+= water.getHeight()){
  			  water.draw(x, y);
      	  } 
  	  }
    }
    public boolean drawLightTowerLight (Graphics g) throws SlickException{
  	  Image light = SpriteCache.instanceOf().getSprite("light.png");
  	  Image img = SpriteCache.instanceOf().getSprite("lighthouse.png");
  	  light.setAlpha((float) 0.7);
  	 
  	  
  	  light.rotate((float) iangle);
  	  g.drawImage(light, (WIDTH/2)-590, (HEIGHT/2)-300);
  	  
  	  
  	  
  	  iangle = 0.5;
  	  //isInTheLight(g);
  	  return false;
  	  
  	  
  	  
    }
    
	public static void main ( String[] args ) throws SlickException {
		TheGame game = new TheGame("A Test");
		AppGameContainer container = new AppGameContainer(game, WIDTH, HEIGHT, false);
		container.start();
	}
}