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
	AISystemMain(String title)
	{
		super(title);
	}

	public void init(GameContainer container) throws SlickException
	{
	}

	public void update(GameContainer container, int i) throws SlickException
	{
	}

	public void render(GameContainer container, Graphics g) throws SlickException
	{
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer app = new AppGameContainer(new AISystemMain("AI System Prototype"));
			app.setDisplayMode(800, 600, false);
			app.start();
		}
		catch(SlickException e){
			System.out.println(e.getMessage());
		}
	}
}