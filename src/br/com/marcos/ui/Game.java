package br.com.marcos.ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import br.com.marcos.model.Direction;
import br.com.marcos.model.Fruit;
import br.com.marcos.model.Point;
import br.com.marcos.model.Snake;

public class Game {
	private JFrame window;
	private Snake snake;
	private Direction currentDirectionSnake;
	private Fruit fruit;
	private List<Drawable> graphics;

	public Game(String title) {
		snake = new Snake(10);
		currentDirectionSnake = Direction.WEST;
		fruit = new Fruit();
		graphics = new ArrayList<>();
		
		window = new JFrame(title);
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().add(new BoardComponent());
		window.addKeyListener(new KeyPress());
		
		graphics.add(snake);
		graphics.add(fruit);
	}

	public void start() {
		window.setVisible(true);
		while (true) {
			try {
				snake.move(currentDirectionSnake);	
				if (ateFruit()) {
					fruit.newLocale();
					snake.incrementBody();
				}
				window.repaint();
				Thread.sleep(50);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private boolean ateFruit() {
		Point head = snake.getHead();
		return head.getX() == fruit.getX() && head.getY() == fruit.getY();
	}
	
	class BoardComponent extends JComponent {
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
			for(Drawable drawable : graphics) {
				drawable.render(g);
			}
		}
	}

	class KeyPress implements KeyListener {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN:
					currentDirectionSnake = Direction.SOUTH;
					break;
				case KeyEvent.VK_UP:
					currentDirectionSnake = Direction.NORTH;
					break;
				case KeyEvent.VK_RIGHT:
					currentDirectionSnake = Direction.EAST;
					break;
				case KeyEvent.VK_LEFT:
					currentDirectionSnake = Direction.WEST;
					break;
			}	
		} 
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
	}

}
