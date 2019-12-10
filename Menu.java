import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;


public class Menu {
	
	public Rectangle playButton = new Rectangle(GamePanel.WIDTH / 11 + 120, 120, 100, 50);
	public Rectangle quitButton = new Rectangle(GamePanel.WIDTH / 11 + 120, 220, 100, 50);

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt0);
		g.setColor(Color.black);
		g.drawString("SNAKE GAME", GamePanel.WIDTH / 4, GamePanel.HEIGHT / 10);
		
		Font fnt1 = new Font("arial", Font.BOLD, 20);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 28, playButton.y + 35);
		g.drawString("Quit", quitButton.x + 28, quitButton.y + 35);
		
		g2d.draw(playButton);
		g2d.draw(quitButton);
	}

}
