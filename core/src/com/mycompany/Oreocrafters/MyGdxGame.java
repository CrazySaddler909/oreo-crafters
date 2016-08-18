package com.mycompany.Oreocrafters;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

@SuppressWarnings("unused")
public class MyGdxGame<Background> extends ApplicationAdapter implements ApplicationListener {
	

//  {
//  		this.resize(Height+250, Width+250);
//  }
	
	/**
	 * OreoCrafters fields.
	 */
	private static final int Width = 0;
	private static final int Height = 0;
	private Object add;
	private Rectangle bucket;
	private OrthographicCamera camera;
	private Texture bucketImage;
	private BitmapFont font2;
	private SpriteBatch batch1;
    private BitmapFont font;
    private SpriteBatch batch;
    private Socket socket;
	TextureRegion upRegion;
	TextureRegion downRegion;
	Texture texture;
	Music oreo1;
	Game game;
	Stage stage;
	
		
	/**
	 * You Tube Tutorial fields.
	 */
	static int java = 13;
	static int python = 3;
	static int ruby = java * python;
	byte CSS= 123;
	short PHP =(short) 32000;
	int HTML = 2000000;
	long  HTML5 = 1234567l;
	float XML = 43.2F;
	double Cplusplus = 123456.7;
	char Chashthag = '@'; 
	static boolean C = true;
	
	public MyGdxGame<Background> Game() {
		MyGdxGame<Background> instance = this;
		return(instance);
	}
		
	@Override
	public void create() {
		
		bucketImage = new Texture(Gdx.files.internal("bucket.jpg"));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		   
		batch = new SpriteBatch();
		
		bucket = new Rectangle();
		bucket.x = 800 / 2 - 64 / 2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;
		
		
		/**
		 * OREO CRAFTERS
		 */
		
		// Texture
		String extRoot = Gdx.files.getExternalStoragePath();
		String locRoot = Gdx.files.getLocalStoragePath();
		System.out.println(extRoot);
		System.out.println(locRoot);
	
		System.out.println("Scanner");
		
		texture = new Texture(Gdx.files.internal("background3.png"));
		batch1 = new SpriteBatch();
		
		 // Texture
		Texture texture2 = new Texture(Gdx.files.internal("Button.png"));
		
		//		font.setColor(Color.PINK);
		
		// Music
		//oreo1 = Gdx.audio.newMusic(Gdx.files.internal("oreo1.ogg"));
		//oreo1.setLooping(true);
		//oreo1.play();
		
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
	//          button.setChecked(true);
//	    		texture = new Texture(Gdx.files.internal("walsall.jpg"));
	            Stage stage2 = new Stage();
//	    		stage2.addActor(button);
	    		stage2.cancelTouchFocus(null);
	    		Gdx.input.setInputProcessor(stage2);
	        }

			private void setBackground() {
				// TODO Auto-generated method stub
				
			}
	        
	    });
				
		stage = new Stage();
		stage.addActor(button);
		stage.cancelTouchFocus(null);
		Gdx.input.setInputProcessor(stage);
	}
	
	@Override
	public void render() {
		
		// Clear Screen 
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch1.begin();
//		batch.draw(texture, Gdx.graphics.getWidth() / 4, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
		batch1.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch1.end();
		stage.draw();

		font = new BitmapFont();  
		
        font2 = null;

        Gdx.graphics.setTitle("Oro Crafters 1.1");
     // Create the bucket Image
     		batch.setProjectionMatrix(camera.combined);
     		batch.begin();
     		batch.draw(bucketImage, bucket.x, bucket.y);
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
     	    //If movement is working it says it in the console.
     		System.out.println("Move work");
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
	
	public int getsize() {
		return 0;
		
	}
	public void init() {     
	
	}

	public void start () {
		
	    C = false;
       
	}
	
	public void end () {
		
	}
	
	public void show () {
		Gdx.input.setInputProcessor(stage);		
	}
	
	private void setResizable(boolean c2) {
				
	}
	
	private void add(JPanel panel2) {
					
	}
	
	private void setLayout(Object object) {
				
	}
	
	private void addKeyListener(MyGdxGame<Background> myGdxGame) {
					
	}
	
	private void setFocusable(boolean c2) {
	
	}
	
	/**
	 * The MAIN method.
	 * @param args
	 */
	
	public static void main(String args[]) {
		
	    System.out.println("works :)");	
		System.out.println(C);
		launch(args);
	}

	private static void launch(String[] args) {
		
	}
}