import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Color;


public class Menu {
	
	public Rectangle playButton = new Rectangle(GamePanel.WIDTH / 11 + 120, 120, 100, 50);
	public Rectangle difficultButton = new Rectangle(GamePanel.WIDTH / 11 + 120, 220, 100, 50);
	public Rectangle quitButton = new Rectangle(GamePanel.WIDTH / 11 + 120, 320, 100, 50);
	private BufferedImage testImage;
	
	public void render(Graphics g) {
		testImage = ImageLoader.loadImage("/background_menu.png");
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(testImage, 0, 0, null);
		
		Font fnt0 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("SNAKE GAME", GamePanel.WIDTH / 4, GamePanel.HEIGHT / 10);
		
		Font fnt1 = new Font("arial", Font.BOLD, 20);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 28, playButton.y + 35);
		g.drawString("Difficult", difficultButton.x + 15, difficultButton.y + 35);
		g.drawString("Quit", quitButton.x + 28, quitButton.y + 35);
		
		g2d.draw(playButton);
		g2d.draw(difficultButton);
		g2d.draw(quitButton);
	}

}
