package beggar.ui;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class StartScreen implements Screen {

	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.write("rl tutorial", 1, 1);
		terminal.writeCenter("-- press [enter] to start --", 2);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		if(key.getKeyCode() == KeyEvent.VK_ENTER){
			return new PlayScreen();
		} else {
			return this;
		}
	}
}
