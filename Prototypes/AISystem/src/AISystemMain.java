import java.util.Vector;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Input;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

/**
 * @version 20-Jul-13
 */
public class AISystemMain extends BasicGame
{
	private Area _area;
	private Vector<Enemy> _listEnemies;
	private Player _player;
	
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

		this._listEnemies = new Vector<Enemy>();
		this._listEnemies.addElement(new Enemy());
		
		this._player = new Player(new Vector2f(10, 10), new Image("assets/Player.png"), 30);
		
		EnemyBehavior.init(this._player);
	}

	private void handleInput(GameContainer container) 
	{
		Input input = container.getInput();

		if(input.isKeyDown(Input.KEY_UP)){
			this._player.setMoveY(-1);
		}

		if(input.isKeyDown(Input.KEY_DOWN)){
			this._player.setMoveY(1);
		}
		
		if(input.isKeyDown(Input.KEY_LEFT)){
			this._player.setMoveX(-1);
		}
		
		if(input.isKeyDown(Input.KEY_RIGHT)){
			this._player.setMoveX(1);
		}
	}
	
	public void update(GameContainer container, int i) throws SlickException
	{
		for(int it=0;it < this._listEnemies.size();++it){
			EnemyBehavior.update(this._listEnemies.elementAt(it));
		}
		
		handleInput(container);
		this._player.update(container, i);
	}

	public void render(GameContainer container, Graphics renderer) throws SlickException
	{
		this._area.render(renderer);
		this._player.render(renderer);
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