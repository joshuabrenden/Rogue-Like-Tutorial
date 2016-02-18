package beggar.ui;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;
import beggar.ui.map.World;
import beggar.ui.map.WorldBuilder;

public class PlayScreen implements Screen {
	private World world;
	private int centerX;
	private int centerY;
	private int screenWidth;
	private int screenHeight;
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		int left = getScrollX();
        int top = getScrollY();
   
        displayTiles(terminal, left, top);
        terminal.write('X', getCenterX() - left, getCenterY() - top);
        
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
        case KeyEvent.VK_ESCAPE: return new LoseScreen();
        case KeyEvent.VK_ENTER: return new WinScreen();
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_H: scrollBy(-1, 0); break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_L: scrollBy( 1, 0); break;
        case KeyEvent.VK_UP:
        case KeyEvent.VK_K: scrollBy( 0,-1); break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_J: scrollBy( 0, 1); break;
        case KeyEvent.VK_Y: scrollBy(-1,-1); break;
        case KeyEvent.VK_U: scrollBy( 1,-1); break;
        case KeyEvent.VK_B: scrollBy(-1, 1); break;
        case KeyEvent.VK_N: scrollBy( 1, 1); break;
		}
    
        return this;
	}
	
	public PlayScreen(){
		setScreenWidth(80);
		setScreenHeight(21);
		createWorld();
	}
	
	public int getScrollX() {
	    return Math.max(0, Math.min(getCenterX() - getScreenWidth() / 2, world.getWidth() - getScreenWidth()));
	}
	
	private void displayTiles(AsciiPanel terminal, int left, int top) {
	    for (int x = 0; x < screenWidth; x++){
	        for (int y = 0; y < screenHeight; y++){
	            int wx = x + left;
	            int wy = y + top;

	            terminal.write(world.glyph(wx, wy), x, y, world.color(wx, wy));
	        }
	    }
	}
	
	private void scrollBy(int mx, int my){
        setCenterX(Math.max(0, Math.min(getCenterX() + mx, world.getWidth() - 1)));
        setCenterY(Math.max(0, Math.min(getCenterY() + my, world.getHeight() - 1)));
    }
	
	public int getScrollY() {
	    return Math.max(0, Math.min(getCenterY() - getScreenHeight() / 2, world.getHeight() - getScreenHeight()));
	}
	
	private void createWorld(){
		setWorld(new WorldBuilder(90,31).makeCaves().build());
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
