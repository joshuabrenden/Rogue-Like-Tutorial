package beggar.actor;

import beggar.ui.map.Tile;

public class PlayerAi extends CreatureAi {

	public PlayerAi(Creature creature) {
		super(creature);
	}
	
	@Override
	public void onEnter(int x, int y, Tile tile){
		if(tile.isGround()){
			creature.setX(x);
			creature.setY(y);
		} else if(tile.isDiggable()){
			creature.dig(x, y);
		}
	}

}
