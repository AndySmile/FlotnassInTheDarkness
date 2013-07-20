import org.newdawn.slick.geom.Vector2f;

/**
 * @version 1.0.0 20-Jul-13
 */
public class EnemyBehavior
{
	protected static Player _player;
	
	public static void init(Player player)
	{
		_player = player;
	}
	
	public static void update(Enemy enemy)
	{
		switch(enemy.getState())
		{
			case Enemy.STATE_SEARCHING:
			{
				/*Vector2f diffVec = enemy.getPosition().sub(_player.getPosition());

				if(diffVec.length() <= 64.0){
					enemy.setState(Enemy.STATE_ATTACK);
				}*/
			}break;
		}
	}
}