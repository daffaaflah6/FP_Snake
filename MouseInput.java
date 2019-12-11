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

		// Easy Button
		if (mx >= GamePanel.WIDTH / 11 + 20 && mx <= GamePanel.WIDTH / 11 + 120) {
			if (my >= 150 && my <= 180) {
				// Pressed Easy Button
				GamePanel.State = GamePanel.STATE.GAME;
			}
		}

		// Medium Button
		if (mx >= GamePanel.WIDTH / 11 + 125 && mx <= GamePanel.WIDTH / 11 + 225) {
			if (my >= 150 && my <= 180) {
				// Pressed Medium Button
				GamePanel.State = GamePanel.STATE.GAME;
			}
		}
		
		// Hard Button
				if (mx >= GamePanel.WIDTH / 11 + 275 && mx <= GamePanel.WIDTH / 11 + 375) {
					if (my >= 150 && my <= 180) {
						// Pressed Hard Button
						GamePanel.State = GamePanel.STATE.GAME;
					}
				}
		
		// Quit Button
		if (mx >= GamePanel.WIDTH / 11 + 120 && mx <= GamePanel.WIDTH / 11 + 220) {
			if (my >= 320 && my <= 370) {
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
