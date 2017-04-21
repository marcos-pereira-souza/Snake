package br.com.marcos.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.marcos.ui.Drawable;

/**
 * 
 * @author Marcos
 *
 */
public class Snake implements Drawable {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;
	private List<Point> body;

	public Snake(int length) {
		body = new ArrayList<>(length);

		for (int i = 1; i <= length; i++) {
			body.add(new Point(i + 30, 10));
		}
	}

	public void incrementBody() {
		Point lastElement = body.get(body.size() - 1);
		Point newBody = new Point(lastElement.getX(), lastElement.getY());
		body.add(newBody);
	}

	public void move(Direction direction) {
		for (int i = body.size() - 1; i > 0; i--) {
			Point current = body.get(i);
			Point previous = body.get(i - 1);
			current.setX(previous.getX());
			current.setY(previous.getY());
		}

		direction.move(this.getHead());
	}

	public List<Point> getBody() {
		return Collections.unmodifiableList(this.body);
	}

	public Point getHead() {
		return this.body.get(0);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		for (br.com.marcos.model.Point member : body) {
			g.fillOval(member.getX() * WIDTH, member.getY() * HEIGHT, WIDTH, HEIGHT);
		}
	}
}
