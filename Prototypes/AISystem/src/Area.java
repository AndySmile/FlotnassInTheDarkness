import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * 
 * @author Andy
 * @version 1.0.0 20-Jul-13
 */
public class Area
{
	final public static int TYPE_WATER = 1;
	final public static int TYPE_BOX = 2;
	final public static int TYPE_ENEMY = 3;
	
	private int _width;
	private int _height;
	private int _map[][];
	private Image _imageWater;
	private Image _imageBox;
	
	public Area(int width, int height)
	{
		this._width = width;
		this._height = height;
		this._map = new int[width][height];
		
		try
		{
			this._imageWater = new Image("assets/Water.png");
			this._imageBox	 = new Image("assets/Box.png");
		}
		catch(Exception e){
			System.out.println("Error during image loading: " + e.getMessage());
		}
	}
	
	public void setType(int x, int y, int type)
	{
		this._map[x][y] = type;
	}
	
	public void render(Graphics renderer)
	{
		for(int x=0;x < this._width;++x)
		{
			for(int y=0;y < this._height;++y)
			{
				switch(this._map[x][y])
				{
					case TYPE_BOX:{
						this._imageBox.draw(x * 64, y * 64);
					}break;
					
					case TYPE_WATER:
					default:{
						this._imageWater.draw(x * 64, y * 64);
					}break;
				}
			}
		}
	}
}