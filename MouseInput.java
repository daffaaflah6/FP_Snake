package id.ac.its.syarif.fppbof3;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {

		int mx = e.getX();
		int my = e.getY();

		/**
		 * public Rectangle playButton = new Rectangle(GamePanel.WIDTH / 11 + 120, 120,
		 * 100, 50); public Rectangle quitButton = new Rectangle(GamePanel.WIDTH / 11 +
		 * 120, 220, 100, 50);
		 */

		// Play Button
		if (mx >= GamePanel.WIDTH / 11 + 120 && mx <= GamePanel.WIDTH / 11 + 220) {
			if (my >= 120 && my <= 170) {
				// Pressed Play Button
				GamePanel.State = GamePanel.STATE.GAME;
			}
		}

		// Quit Button
		if (mx >= GamePanel.WIDTH / 11 + 120 && mx <= GamePanel.WIDTH / 11 + 220) {
			if (my >= 220 && my <= 270) {
				// Pressed Quit Button
				System.exit(1);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
