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
import org.newdawn.slick.tiled.TiledMap;
 
public class Pong extends BasicGame {
     
      public static final int WIDTH = 800;
      public static final int HEIGHT = 600;
      public Image waterG;
      public Image water;
      private TiledMap map;
      double iangle;
      
      public Shape s;
      public Pong() {
            super("Foltsom in the Darkness");
      }
 
      public void init(GameContainer gc) throws SlickException {
    	  water = new Image("img/water.png");
    	  waterG = new Image (WIDTH, HEIGHT);
//    	  map = new TiledMap("map/map1.tmx");
    	  iangle = 0.0;
    	  
    	  s = null;
    	  float[] TowerPolygon = new float[]{0, 0,  850, 850, 400, 250};
    	  s = new Polygon (TowerPolygon);
    	  
    	  
    	  
      }
 
      public void update(GameContainer gc, int delta) throws SlickException {
            // Abfangen der Eingabegaräte
            Input input = gc.getInput();
      }
 
      public void render(GameContainer gc, Graphics g) throws SlickException {

    	  drawWater(g);
    	  letThereBeDarkness(g);
    	  // Draw Lighthouse
    	  Image img = new Image("img/lighthouse.png");
    	  img.draw((WIDTH/2)-(img.getWidth()/2), (HEIGHT/2)-(img.getHeight()/2));
    	  drawLightTowerLight(g);
    	  Image img2 = new Image("img/lighthouse_top.png");
    	  img2.draw((WIDTH/2)-(img2.getWidth()/2), (HEIGHT/2)-(img2.getHeight()/2));
    	
    	 
    	  
    	  
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
    	  Image light = new Image ("img/light.png");
    	  Image img = new Image("img/lighthouse.png");
    	  light.setAlpha((float) 0.7);
    	 
    	  
    	  light.rotate((float) iangle);
    	  g.drawImage(light, (WIDTH/2)-590, (HEIGHT/2)-300);
    	  
    	  
    	  
    	  iangle += 0.5;
    	  //isInTheLight(g);
    	  return false;
    	  
    	  
    	  
      }
      
      public static void main(String[] args) throws SlickException {
            AppGameContainer pong = new AppGameContainer(new Pong());
            pong.setDisplayMode(WIDTH, HEIGHT, false);
            pong.setVSync(true);
            pong.setShowFPS(true);
            pong.start();
      }
}