package com.mycompany.Oreocrafters.mods;

import com.mycompany.Oreocrafters.MyGdxGame;

public class Zombie extends MyGdxGame {
	
	/*
	 * All the fileds.
	 */
	
	private int height;
	private int width;
	private int scale;		
	private int drawRect;
	
	public void create (boolean hit) {
	
		
		/*
		 * Zombie.
		 */
		
    draw(width = 17);
    draw(width = 19);
    draw(height = 26);
    draw(height = 5);
    draw(scale = 24);
    draw(scale = 43);
    
    drawRect(width = 17);
    drawRect(height = 17);
    drawRect(scale = 34);
    setColor(1, 1, 1);
    
    try {
      System.out.println("waiting...");
		wait();
	}catch (InterruptedException e) {
		e.printStackTrace();
	}
    
    /*
     * Drop.
     */
   
	if(hit= false);
	    return;
	}
	
	private void setColor(int i, int j, int k) {
		
	}

	private void drawRect(int i) {
		
	}

	public void render () {
		
	}


	private void draw(int i) {
		
	}
}
