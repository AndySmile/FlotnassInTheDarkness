import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * @version 1.0.0 20-Jul-13
 */
public class Enemy extends Entity
{
	final public static int STATE_SEARCHING = 1;
	final public static int STATE_ATTACK = 2;
	
	protected int _state;
	protected Image _image;
	
	public Enemy()
	{
		this._state = STATE_SEARCHING;
		
		try{
			this._image = new Image("assets/Enemy.png");
		}
		catch(Exception e){
			System.out.println("Failure during loading enemy image: " + e.getMessage());
		}
	}
	
	public void setState(int state)
	{
		this._state = state;
	}
	
	public int getState()
	{
		return this._state;
	}
	
	public void render(Graphics renderer)
	{
		this._image.draw(this._position.x, this._position.y);
	}
}