package beggar.ui;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class WinScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("You won.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);

	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		Screen nextScreen = null;
		
		if(key.getKeyCode() == KeyEvent.VK_ENTER){
			nextScreen = new LoseScreen();
		}
		
		return nextScreen;
	}
}
