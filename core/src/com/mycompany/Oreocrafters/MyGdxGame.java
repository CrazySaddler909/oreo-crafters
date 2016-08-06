package com.mycompany.Oreocrafters;

import java.awt.Component;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import javax.swing.JFrame;

@SuppressWarnings("unused")
public class MyGdxGame<Background> extends ApplicationAdapter implements ApplicationListener {
	
	public static void main1(String args[]) {
        GameMenu menu = new GameMenu();
        menu.setSize(760, 700);
        menu.setLocation(200, 25);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	
	 private JButton play1;
	    private JButton exit1;
	    private JButton about1;
	    private JButton credit1;
	    private ImageIcon img1;
	    private JLabel imgLabel1;
	    private JPanel panel1;
	    private float h1 = (float) 0.333;
	    private float b1= (float) 0.600;
	    private float s1 = 1;
	    boolean runCheck1 = false;
	    public GameFrame frame1;
	    private JButton exit;
	    private JButton about;
	    private JButton credit;
	    private ImageIcon img;
	    private JLabel imgLabel;
	    private JPanel panel;
	    private float h = (float) 0.333;
	    private float b = (float) 0.600;
	    private float s = 1;
	    boolean runCheck = false;
	    public GameFrame frame;
	    
	    void GameFrame() {
	        /*
	         * setSize(760,700);
	         * setLocation(200,25);
	         * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         * setResizable(false);
	         * setVisible(true);
	         */
	        setLayout(null);
	         int c = 500;
	         int d = 530;

	        int a = 1;
	        b = 1;
	        int x = 50;
	        int y = 250;

	        int f = 50;
	        int k = 700;
	        h = 1;
	        int i = -1;

	        s = 1;

	        addKeyListener(this);
	        setFocusable(true);
	        
	        setLayout(null);
	        setResizable(false);

	        panel = new JPanel();
	        panel.setLayout(null);
	        panel.setSize(760, 700);
	        add(panel);
	        Component play = new JButton("PLAY");
	        play.setSize(100, 50);
	        play.setLocation(360, 400);
	        panel.add(play);

	        about = new JButton("ABOUT");
	        about.setSize(play.getSize());
	        about.setLocation(play.getX(), play.getY() + play.getHeight() + 50);
	        panel.add(about);

	        exit = new JButton("EXIT");
	        exit.setSize(play.getSize());
	        exit.setLocation(about.getX() + about.getWidth() + 50, about.getY());
	        panel.add(exit);

	        credit = new JButton("CREDIT");
	        credit.setSize(play.getSize());
	        credit.setLocation(about.getX() - about.getWidth() - 50, about.getY());
	        panel.add(credit);

	        img = new ImageIcon("C:\\Users\\Ghulam Haider\\Downloads\\b.jpg");

	        imgLabel = new JLabel(img);
	        imgLabel.setSize(imgLabel.getPreferredSize());
	        imgLabel.setLocation(230, 45);
	        panel.add(imgLabel);
	        mouseListener mouse = new mouseListener();
	        play.addMouseListener((MouseListener) mouse);
	        
	        
	        
	        
	    }
	
	private void setResizable(boolean c2) {
			// TODO Auto-generated method stub
			
		}

	private void add(JPanel panel2) {
			// TODO Auto-generated method stub
			
		}

	private void setLayout(Object object) {
			// TODO Auto-generated method stub
			
		}

	private void addKeyListener(MyGdxGame<Background> myGdxGame) {
			// TODO Auto-generated method stub
			
		}

	private void setFocusable(boolean c2) {
			// TODO Auto-generated method stub
			
		}

	protected static final String Log = null;
	
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
	
	public static void main (String args []) {
	System.out.println("works :)");	
		
		System.out.println(C);
	}
	
	private SpriteBatch batch1;
    private BitmapFont font;
    
	Texture texture;
	 SpriteBatch batch;
	 Music oreo1;
	Game game;
	    Stage stage;

		private Object add;
	
	@Override
	public void create() {
		// Texture
		String extRoot = Gdx.files.getExternalStoragePath();
		String locRoot = Gdx.files.getLocalStoragePath();
		System.out.println(extRoot);
		System.out.println(locRoot);
		texture = new Texture(Gdx.files.internal("background3.png"));
		batch1 = new SpriteBatch();
		
		//		font.setColor(Color.PINK);
		
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
		batch1.begin();
//		batch.draw(texture, Gdx.graphics.getWidth() / 4, 0, Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
		batch1.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch1.end();
		stage.draw();

		font = new BitmapFont();
//		font = new BitmapFont(Gdx.files.internal("data/arial-15.fnt"),false);   
       
        font2 = null;
//		font2.draw(batch1, "Bana!", 200, 200);
 //       batch1.end();

        Gdx.graphics.setTitle("Oro Crafters 1.1");
        
        
        
	}
	
public void dispose () {
	
	 batch1.dispose();
     font.dispose();
	
}


public void regstier () {


    
}
	

private BitmapFont font2;


public void init()
{     

}

public void start () {

	
	
}

public void end () {
	
}

public void show () {
	
	Gdx.input.setInputProcessor(stage);	
	
}


}