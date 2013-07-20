import org.newdawn.slick.geom.Vector2f;

/**
 * @version 1.0.0 20-Jul-13
 */
public class Entity
{
	protected Vector2f _position;
	
	public Vector2f getPosition()
	{
		return this._position;
	}
	
	public void setPosition(Vector2f position)
	{
		this._position = position;
	}
}