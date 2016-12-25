package com.mycompany.Oreocrafters;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Drop extends ApplicationAdapter {	
	
	  public SpriteBatch batch;
	    public BitmapFont font;


	    OrthographicCamera camera1;
	
/**
 * DROP GAME fields
 */
private Texture dropImage;
private Texture bucketImage;
private Sound dropSound;
private Music rainMusic;
private OrthographicCamera camera;
private Rectangle bucket;
	

	@Override
	public void create() {
	
		/**
		 * DROP GAME 
		 */
		
		batch = new SpriteBatch();
        //Use LibGDX's default Arial font.
        font = new BitmapFont();
       /////////// this.setScreen(new MainMenuScreen(this));
		
		// load the images for the droplet and the bucket, 64x64 pixels each
		dropImage = new Texture(Gdx.files.internal("walsall.jpg"));
		bucketImage = new Texture(Gdx.files.internal("bucket.jpg"));
	
		// load the drop sound effect and the rain background "music"
		dropSound = Gdx.audio.newSound(Gdx.files.internal("allezOh.mp3"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("allezOh.mp3"));
	
		// start the playback of the background music immediately
		rainMusic.setLooping(true);
		rainMusic.play();
		
		camera1 = new OrthographicCamera();
		camera1.setToOrtho(false, 800, 480);
		   
		batch = new SpriteBatch();
		
		bucket = new Rectangle();
		bucket.x = 800 / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;
	}

	public void setScreen(Screen mainMenuScreen) {		
	}

	@Override
	public void render() {
	    // Clear Screen to blue
	    Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera1.update();
		
		// Create the bucket Image
		batch.setProjectionMatrix(camera1.combined);
		batch.begin();
		batch.draw(bucketImage, bucket.x, bucket.y);
		batch.end();
		
		// Moves bucket if Mouse used
		if(Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera1.unproject(touchPos);
			bucket.x = touchPos.x - 64 / 2;
		}
		
		// Moves bucket if the left right keys are pressed
		if(Gdx.input.isKeyPressed(Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();
		// Stop bucket going off screen
		if(bucket.x < 0) bucket.x = 0;
		if(bucket.x > 800 - 64) bucket.x = 800 - 64;
		
		// Moves bucket if up down keys pressed.
		if(Gdx.input.isKeyPressed(Keys.DOWN)) bucket.y -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.UP)) bucket.y += 200 * Gdx.graphics.getDeltaTime();
		// FIXME Bucket goes off screen
		if(bucket.x < 0) bucket.y = 0;
		if(bucket.x > 800 - 64) bucket.y = 800 - 64;
		
		 super.render(); //important!
	}
	
	public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
