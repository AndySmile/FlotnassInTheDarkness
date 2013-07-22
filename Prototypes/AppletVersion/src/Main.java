import javax.swing.JApplet;
import org.newdawn.slick.AppGameContainer;

/**
 * @version 	1.0.0 22-Jul-13
 * @copyright	Copyright (c) 2013 by Andy Liebke. All rights reserved. (http://andysmiles4games.com)
 */
public class Main extends JApplet
{
	public void start()
	{
		try
		{
			AppGameContainer app = new AppGameContainer(new TestGame());
			app.setDisplayMode(800, 600, false);
			app.start();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}