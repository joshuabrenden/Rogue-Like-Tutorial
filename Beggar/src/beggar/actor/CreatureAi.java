package beggar.actor;

import beggar.ui.map.Tile;

public class CreatureAi {
	protected Creature creature;
	
	public CreatureAi(Creature creature){
		this.creature = creature;
		this.creature.setAi(this);
	}
	
	public void onEnter(int x, int y, Tile tile){
		
	}
}
