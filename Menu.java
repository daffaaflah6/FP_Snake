import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Color;


public class Menu {
	
	public Rectangle easyButton = new Rectangle(GamePanel.WIDTH / 11 + 20, 150, 60, 30);
	public Rectangle mediumButton = new Rectangle(GamePanel.WIDTH / 11 + 125, 150, 90, 30);
	public Rectangle hardButton = new Rectangle(GamePanel.WIDTH / 11 + 275, 150, 60, 30);
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
		
		Font fnt2 = new Font("Futura Bk BT", Font.PLAIN, 30);
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("Choose Your Difficulties", GamePanel.WIDTH / 11 + 20, GamePanel.HEIGHT / 10 + 70);
		
		Font fnt1 = new Font("arial", Font.BOLD, 20);
		g.setFont(fnt1);
		g.drawString("Easy", easyButton.x + 8, easyButton.y + 22);
		g.drawString("Medium", mediumButton.x + 8, mediumButton.y + 22);
		g.drawString("Hard", hardButton.x + 8, hardButton.y + 22);
		g.drawString("Quit", quitButton.x + 28, quitButton.y + 35);
		
		g2d.draw(easyButton);
		g2d.draw(mediumButton);
		g2d.draw(hardButton);
		g2d.draw(quitButton);
	}

}
