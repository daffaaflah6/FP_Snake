import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable, KeyListener {
	//These are like a team they can't work without eachother
		public static final int WIDTH = 400;
		public static final int HEIGHT = 400;
		//Render
		private Graphics2D g2d;
		private BufferedImage image;
		private BufferedImage testImage;
		//Game Loop
		private Thread thread;
		private boolean running;
		private long targetTime;
		
		//Game Stuff
		private final int SIZE = 10;
		private Entity head,apple;
		private ArrayList<Entity> snake;
		private int score;
		private int level;
		private int life;
		private boolean gameover;
		//Movement
		private int dx,dy;
		
		//Menu
		private Menu menu;
		public static enum STATE{
			MENU,
			GAME
		};
		
		public static STATE State = STATE.MENU;
		public static STATE State2 = STATE.GAME;
		
		//Key Input
		private boolean up,down,right,left,start;
		
		public GamePanel() {
			setPreferredSize(new Dimension(WIDTH, HEIGHT));
			setFocusable(true);
			requestFocus();
			addKeyListener(this);
		}
		public void addNotify() {
			super.addNotify();
			thread = new Thread(this);
			thread.start();
		}
		private void setFPS(int fps) {
			targetTime = 2500 / fps;
		}
		@Override
		public void keyPressed(KeyEvent e) {
			int k = e.getKeyCode();
			if(State == STATE.GAME) {
				if(k == KeyEvent.VK_UP) up = true;
				if(k == KeyEvent.VK_DOWN) down = true;
				if(k == KeyEvent.VK_LEFT) left = true;
				if(k == KeyEvent.VK_RIGHT) right = true;
				if(k == KeyEvent.VK_ENTER) start = true;
				if(k == KeyEvent.VK_Q) System.exit(1);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int k = e.getKeyCode();
			
			if(k == KeyEvent.VK_UP) up = false;
			if(k == KeyEvent.VK_DOWN) down = false;
			if(k == KeyEvent.VK_LEFT) left = false;
			if(k == KeyEvent.VK_RIGHT) right = false;
			if(k == KeyEvent.VK_ENTER) start = false;
			if(k == KeyEvent.VK_Q) System.exit(0);
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}

		@Override
		public void run() {
			if(running) return;
			init();
			long startTime;
			long elapsed;
			long wait;
			while(running) {
				
				startTime = System.nanoTime();
				Sound.PLAY.play();
				
				try {
					update();
					requestRender();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				elapsed = System.nanoTime() - startTime;
				wait = targetTime - elapsed /1000000;
				if(wait > 0) {
					try {
						Thread.sleep(wait);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		private void init() {
			image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
			g2d = image.createGraphics();
			running = true;
			setUplevel();
			gameover = false;
			Sound.PLAY.play();
			level = 1;
			life = 3;
			setFPS(level * 20);
			menu = new Menu();
			
			this.addMouseListener(new MouseInput());
			
			testImage = ImageLoader.loadImage("/background.png");
		}
		private void setUplevel() {
			snake = new ArrayList<Entity>();
			head = new Entity(SIZE);
			head.setPosition(WIDTH / 2, HEIGHT / 2);
			snake.add(head);
			
			for(int i = 1;i < 3;i++) {
				Entity e = new Entity(SIZE);
				e.setPosition(head.getX() + (i * SIZE), head.getY());
				snake.add(e);
			}
			apple = new Entity(SIZE);
			setApple();
			score = 0;
			dx = dy = 0;
			gameover = false;
			Sound.PLAY.play();
		}
		
		public void setApple() {
			int x = (int)(Math.random() * (WIDTH - SIZE));
			int y = (int)(Math.random() * (HEIGHT - SIZE));
			x = x - (x % SIZE);
			y = y - (y % SIZE);
			apple.setPosition(x, y);
		}
		private void requestRender() {
			
			if(State == STATE.GAME) {
				render(g2d);
			
			}else if(State == STATE.MENU) {
				menu.render(g2d);
				
			}
			
			Graphics g = getGraphics();
			g.drawImage(image, 0,0,null);
			g.dispose();

		}
		
		private void update() throws InterruptedException {
			
			if(gameover) {
				if(start) {
					
					setUplevel();
					Sound.PLAY.play();
					
				}
				return;
			}
			if(up && dy == 0) {
				dy =- SIZE;
				dx = 0;
			}
			if(down && dy == 0) {
				dy = SIZE;
				dx = 0;
			}
			if(left && dx == 0) {
				dy = 0;
				dx =- SIZE;
			}
			if(right && dx == 0 && dy != 0) {
				dy = 0;
				dx = SIZE;
			}
			
			if(dx != 0 || dy != 0) {
				for(int i = snake.size() - 1;i > 0;i--) {
				
				    snake.get(i).setPosition(
						    snake.get(i - 1).getX(),
						    snake.get(i - 1).getY()
						    );
			    }
			    head.move(dx, dy);
			}
			
			for(Entity e : snake) {
				if(e.isCollsion(head)) {
					life--;
					if(life == 0) {
						gameover = true;
						level = 1;
						life = 3;
						setFPS(20);
					}
					break;
				}
				
			}
			
			if(apple.isCollsion(head)) {
				score++;
				setApple();
				
				Entity e = new Entity(SIZE);
				e.setPosition(-100,-100);
				snake.add(e);
				
				if(score % 10 == 0) {
					Sound.LEVELUP.play();
					level++;
					if(level > 20) level = 20;
					if(State == STATE.GAME) {
						setFPS(level * 20);
					}
					else if(State == STATE.GAME) {
						setFPS(level * 70);
					}
					else if(State == STATE.GAME) {
						setFPS(level * 120);
					}
				}
				else Sound.EAT.play();
			}
			
			if(head.getX() < 0) head.setX(WIDTH);
			if(head.getY() < 0) head.setY(HEIGHT);
			if(head.getX() > WIDTH) head.setX(0);
			if(head.getY() > HEIGHT) head.setY(0);
			
		}
		
		public void render(Graphics2D g2d) {
			g2d.drawImage(testImage, 0, 0, null);
			
			g2d.setColor(Color.GREEN);
			for(Entity e : snake) {
				//Hapus state yang di entity
					e.render(g2d);
				
			}
			
			g2d.setColor(Color.RED);
			//Hapus state di apple
				apple.render(g2d);
			
			if(gameover) {
				g2d.drawString("Game Over!", 150, 200);
				g2d.drawString("Press Enter to Restart", 100, 220);
				g2d.drawString("Or (Q) to Quit", 140, 240);
			}

			g2d.setColor(Color.WHITE);
			g2d.drawString("Score : " + score + "   Level : " + level + "   Life : " + life, 20, 20);
			if(dx == 0 && dy == 0) {
				g2d.drawString("Ready!", 170, 200);
				g2d.drawString("Press Up Arrow to Start", 100, 220);
				Sound.PLAY.play();
			}
			
}
}
