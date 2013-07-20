import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.BasicGame;

/**
 * @version 20-Jul-13
 */
public class AISystemMain extends BasicGame
{
	private Area _area;
	
	AISystemMain(String title)
	{
		super(title);
	}

	public void init(GameContainer container) throws SlickException
	{
		this._area = new Area(60, 60);
		this._area.setType(1, 1, Area.TYPE_BOX);
		this._area.setType(2, 2, Area.TYPE_BOX);
		this._area.setType(5, 8, Area.TYPE_BOX);
	}

	public void update(GameContainer container, int i) throws SlickException
	{
	}

	public void render(GameContainer container, Graphics renderer) throws SlickException
	{
		this._area.render(renderer);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer app = new AppGameContainer(new AISystemMain("AI System Prototype"));
			app.setDisplayMode(800, 600, false);
			app.start();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}