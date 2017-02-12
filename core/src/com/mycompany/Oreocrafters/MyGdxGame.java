package com.mycompany.Oreocrafters;

import java.awt.Graphics2D;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MyGdxGame extends ApplicationAdapter implements ApplicationListener  {
	
	
  //OreoCrafters fields.
	 
	private Rectangle bucket;
	
	private OrthographicCamera camera;
	private Texture player;
	private SpriteBatch batch1;
    private BitmapFont font;
    private SpriteBatch batch;

        
	TextureRegion upRegion;
	TextureRegion downRegion;
	Texture texture;
	Music oreo1;
	@Override
		public void create() {
			
			bucket = new Rectangle();
			player = new Texture(Gdx.files.internal("player.png"));
			camera = new OrthographicCamera();
			camera.setToOrtho(false, 800, 480);
			   
			batch = new SpriteBatch();
			
			/**
			 * OREO CRAFTERS
			 */
			
			// Texture
			String extRoot = Gdx.files.getExternalStoragePath();
			String locRoot = Gdx.files.getLocalStoragePath();
			System.out.println(extRoot);
			System.out.println(locRoot);
			
			texture = new Texture(Gdx.files.internal("Bro.png"));
			batch1 = new SpriteBatch();
			
			 // Texture
			Texture texture2 = new Texture(Gdx.files.internal("Button.png"));
					
			Music
			oreo1 = Gdx.audio.newMusic(Gdx.files.internal("oreo1.ogg"));
			oreo1.setLooping(true);
			oreo1.play();
			
	//		Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
	//		Skin skin = new Skin();
			
			
			TextureRegion upRegion = new TextureRegion(texture, 120, 120, 150, 150);
			TextureRegion downRegion = new TextureRegion(texture2, 120, 120, 150, 150);
			BitmapFont buttonFont = new BitmapFont();
	
			TextButtonStyle style = new TextButtonStyle();
			style.up = new TextureRegionDrawable(upRegion);
			style.down = new TextureRegionDrawable(downRegion);
			style.font = buttonFont;
			
			final TextButton button = new TextButton("Play Game", style);
			button.getStyle().checked = button.getStyle().up;
			button.addListener(new ChangeListener() {
		        @Override 
		        public void changed (ChangeEvent event, Actor actor) {
		            System.out.println("Button Pressed");
		            System.out.println("Button Realsed");
	                //button.setChecked(true);
	                //texture = new Texture(Gdx.files.internal("walsall.jpg"));
		            Stage stage2 = new Stage();
	         		//stage2.addActor(button);
		    		stage2.cancelTouchFocus(null);
		    		Gdx.input.setInputProcessor(stage2);
		        }
		        
		    });
					
			stage = new Stage();
			stage.addActor(button);
			stage.cancelTouchFocus(null);
			Gdx.input.setInputProcessor(stage);
		}

	Game game;
	Stage stage;

	@Override
	public void render() {
		
		super.render();
		
		// Clear Screen 
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch1.begin();
//		batch.draw(texture, Gdx.graphics.getWidth() / 4, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
		batch1.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch1.end();
		stage.draw();

		font = new BitmapFont();  

        Gdx.graphics.setTitle("Oro Crafters 1.1");
    	// Create the bucket Image
 		batch.setProjectionMatrix(camera.combined);
 		batch.begin();
 		batch.draw(player, bucket.x, bucket.y);
 		batch.end();
 		
    	// Moves bucket if Mouse used
 		if(Gdx.input.isTouched()) {
 			Vector3 touchPos = new Vector3();
 			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
 			camera.unproject(touchPos);
 			bucket.x = touchPos.x - 64 / 2;      
 		}
 		
 		// Moves bucket if the left right keys are pressed
 		if(Gdx.input.isKeyPressed(Keys.A)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
 		if(Gdx.input.isKeyPressed(Keys.D)) bucket.x += 200 * Gdx.graphics.getDeltaTime();
 		// Stop bucket going off screen
 		if(bucket.x < 0) bucket.x = 0;
 		if(bucket.x > 800 - 64) bucket.x = 800 - 64;
 		// Moves bucket if up down keys pressed.
 		if(Gdx.input.isKeyPressed(Keys.S)) bucket.y -= 200 * Gdx.graphics.getDeltaTime();
 		if(Gdx.input.isKeyPressed(Keys.W)) bucket.y += 200 * Gdx.graphics.getDeltaTime();
 	    // If movement is working it says it in the console.
 		//System.out.println("Move work");
 		// FIXME Bucket goes off screen
 		if(bucket.x < 0) bucket.y = 0;
 		if(bucket.x > 800 - 64) bucket.y = 64 - 800;
		 		
	}
 	  

	public void dispose () {
		
		 batch1.dispose();
	     font.dispose();
		
	}
	
	
	public void regstier () {
	   
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void show () {
		Gdx.input.setInputProcessor(stage);		
	}
	
	public void Graphics(Graphics2D g) {
		
	}
	
		@Override
		    public void pause(){	
			
		    }

		    @Override
		    public void resume() {
		    	
		    }
		    
		}
