package beggar.ui.map;

import java.awt.Color;

import beggar.actor.Creature;

public class World {
	private Tile[][] tiles;
	private int width;
	private int height;
	
	public World(Tile[][] tiles){
		setTiles(tiles);
		setWidth(getTiles().length);
		setHeight(getTiles()[0].length);
	}
	
	public Tile tile(int x, int y){
        if (x < 0 || x >= width || y < 0 || y >= height)
            return Tile.BOUNDS;
        else
            return tiles[x][y];
    }

	public char glyph(int x, int y){
        return tile(x, y).getGlyph();
    }

	public Color color(int x, int y){
        return tile(x, y).getColor();
    }
	
	public void dig(int x, int y){
		if (getTiles()[x][y].isDiggable()){
			updateTiles(x,y,Tile.FLOOR);
		}
	}
	
	private void updateTiles(int x, int y, Tile tile){
		tiles[x][y] = tile;
	}
	
	public void addAtEmptyLocation(Creature creature){
		int x;
	    int y;

	    do {
	        x = (int)(Math.random() * getWidth());
	        y = (int)(Math.random() * getHeight());
	    }
	    while (!tile(x,y).isGround());

	    creature.setX(x);
	    creature.setY(y);
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
	
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
}
