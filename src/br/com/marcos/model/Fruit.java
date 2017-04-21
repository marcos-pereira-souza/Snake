package br.com.marcos.model;

import java.awt.Color;
import java.awt.Graphics;

import br.com.marcos.ui.Drawable;

public class Fruit implements Drawable {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;
	private Point p;

	public Fruit() {
		p = new Point();
		newLocale();
	}

	public int getX() {
		return this.p.getX();
	}

	public int getY() {
		return this.p.getY();
	}

	public void newLocale() {
		p.setX((int) (Math.random() * 45));
		p.setY((int) (Math.random() * 45));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(getX() * WIDTH, getY() * HEIGHT, WIDTH, HEIGHT);
	}
}
