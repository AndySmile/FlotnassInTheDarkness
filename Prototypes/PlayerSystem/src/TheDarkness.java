import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class TheDarkness {
	private static ArrayList<Shape> lights = new ArrayList<Shape>();
	private Image alphaMap;
	
	public TheDarkness(int width, int height) throws SlickException {
		alphaMap = new Image(width, height);
		
		lights.add(new Ellipse(100, 100, 100, 100));		
	}

	public void render(Graphics pen) throws SlickException {		
		Graphics img = alphaMap.getGraphics();
		Color color = new Color(30,30,60, 170);
		img.setColor(color);
		img.fill(new Rectangle(0, 0, alphaMap.getWidth(), alphaMap.getHeight()));
		
		img.setDrawMode(Graphics.MODE_ALPHA_MAP);
		img.setColor(new Color(255,255,255,0));
		
		for(Shape s : lights) {
			img.fill(s);
		}
		
		pen.drawImage(alphaMap, 0, 0);
	}

	public static ArrayList<Shape> getLights() {
		return lights;
	}

	public static void setLights(ArrayList<Shape> lights) {
		TheDarkness.lights = lights;
	}
}
