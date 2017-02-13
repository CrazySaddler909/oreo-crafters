package com.crazysaddler.cubsproject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author a180906
 *
 */
public class MyWindow extends JPanel {
	
   private static final long serialVersionUID = -3592540922963019935L;
   public static final int WIDTH = 800;
   public static final int HEIGHT = 600;
   private static final String TITLE = ("Cubs game");
   
   public void render() {
   }

    /**
     * 
     */
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		Image img1 = Toolkit.getDefaultToolkit().getImage("res/levels/level1.png");
	    g2.drawImage(img1, 1, 1, this);
	    g2.finalize();
	    
		Graphics2D g21 = (Graphics2D) g;
		Image img21 = Toolkit.getDefaultToolkit().getImage("res/levels/Charcter.png");
        g21.drawImage(img21, 0, 0, this);
	    g21.finalize();
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
       
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setTitle(TITLE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
	    frame.getContentPane().add(new MyWindow());
	    frame.setVisible(true);
	    new MyWindow();
	    
	}
}
