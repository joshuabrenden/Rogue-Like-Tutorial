package beggar.actor;

import java.awt.Color;

import beggar.ui.map.World;

public class Creature {
	private World world;
	private int x;
	private int y;
	private char glyph;
	private Color color;
	private CreatureAi ai;
	
	public Creature(World world, char glyph, Color color){
		this.world = world;
		this.glyph = glyph;
		this.setColor(color);
	}
	
	public void dig(int wx, int wy){
		world.dig(wx,wy);
	}
	
	public void moveBy(int mx, int my){
	    ai.onEnter(x+mx, y+my, world.tile(x+mx, y+my));
	}
	
	public char getGlyph() {
		return glyph;
	}

	public void setGlyph(char glyph) {
		this.glyph = glyph;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public CreatureAi getAi() {
		return ai;
	}

	public void setAi(CreatureAi ai) {
		this.ai = ai;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

}
