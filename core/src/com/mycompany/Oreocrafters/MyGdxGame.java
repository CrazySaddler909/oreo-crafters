package com.mycompany.Oreocrafters;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public class MyGdxGame extends ApplicationAdapter implements ApplicationListener {
	
	Texture texture;
	SpriteBatch batch;
	//Music oreo1;
//	Game game;
	Stage stage;
	
	@Override
	public void create() {
		// Texture
		texture = new Texture(Gdx.files.internal("background.png"));
		batch = new SpriteBatch();
		
		// Music
		//oreo1 = Gdx.audio.newMusic(Gdx.files.internal("oreo1.ogg"));
		//oreo1.setLooping(true);
		//oreo1.play();
		
//		Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
//		Skin skin = new Skin();
		
		TextureRegion upRegion = new TextureRegion(texture, 20, 20, 50, 50);
		TextureRegion downRegion = new TextureRegion(texture, 40, 40, 100, 100);
		BitmapFont buttonFont = new BitmapFont();

		TextButtonStyle style = new TextButtonStyle();
		style.up = new TextureRegionDrawable(upRegion);
		style.down = new TextureRegionDrawable(downRegion);
		style.font = buttonFont;
		
		final TextButton button = new TextButton("Play Game", style);
		button.addListener(new ChangeListener() {
	        @Override
	        public void changed (ChangeEvent event, Actor actor) {
	            System.out.println("Button Pressed");
	            
	        }
	    });
				
		stage = new Stage();
		stage.addActor(button);
		stage.cancelTouchFocus(null);
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
//		batch.draw(texture, Gdx.graphics.getWidth() / 4, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
		batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		stage.draw();

	}
	
public void dispose () {
	
	
	
}

public void regstier () {
	
}
	
}
