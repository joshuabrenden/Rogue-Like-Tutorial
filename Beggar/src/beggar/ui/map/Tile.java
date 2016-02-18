package beggar.ui.map;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public enum Tile {
	FLOOR((char)250, AsciiPanel.yellow),
	WALL((char)177, AsciiPanel.yellow),
	BOUNDS('x', AsciiPanel.brightBlack);
	
	private char glyph;
	
	private Color color;
	
	Tile (char glyph, Color color){
		setGlyph(glyph);
		setColor(color);
	}

	public boolean isDiggable(){
		return this == Tile.WALL;
	}
	
	public boolean isGround(){
		return this == Tile.FLOOR && !isBounds();
	}
	
	public boolean isBounds(){
		return this == Tile.BOUNDS;
	}
	
	public char getGlyph() {
		return glyph;
	}

	public void setGlyph(char glyph) {
		this.glyph = glyph;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
