package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mycompany.Oreocrafters.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
	    LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	    

	    config.width = 800;
	    config.height = 600;
	    //OreoCrafters
        new LwjglApplication(new MyGdxGame(), config);

		//Drop
		//config.title = "Drop";
		//new LwjglApplication(new Drop(), config);
	}
}	
