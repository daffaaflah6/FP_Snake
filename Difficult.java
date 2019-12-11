import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Color;


public class Difficult {
	
	public Rectangle easyButton = new Rectangle(GamePanel.WIDTH / 11 + 120, 120, 100, 50);
	public Rectangle mediumButton = new Rectangle(GamePanel.WIDTH / 11 + 120, 220, 100, 50);
	public Rectangle hardButton = new Rectangle(GamePanel.WIDTH / 11 + 120, 320, 100, 50);
	private BufferedImage testImage;

	public void render(Graphics g) {
		testImage = ImageLoader.loadImage("/background_difficult.png");
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(testImage, 0, 0, null);
		Font fnt0 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("DIFFICULTIES", GamePanel.WIDTH / 4, GamePanel.HEIGHT / 10);
		
		Font fnt1 = new Font("arial", Font.BOLD, 20);
		g.setFont(fnt1);
		g.drawString("Easy", easyButton.x + 28, easyButton.y + 35);
		g.drawString("Medium", mediumButton.x + 15, mediumButton.y + 35);
		g.drawString("Hard", hardButton.x + 28, hardButton.y + 35);
		
		g2d.draw(easyButton);
		g2d.draw(mediumButton);
		g2d.draw(hardButton);
	}

}
