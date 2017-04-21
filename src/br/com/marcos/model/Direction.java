package br.com.marcos.model;

public enum Direction{
	
	WEST {
		@Override
		public void move(Point p) {
			p.setX(p.getX() - 1);
		}
	}, NORTH {
		@Override
		public void move(Point p) {
			p.setY(p.getY() - 1);
		}
	}, EAST {
		@Override
		public void move(Point p) {
			p.setX(p.getX() + 1);
		}
	}, SOUTH {
		@Override
		public void move(Point p) {
			p.setY(p.getY() + 1);
		}
	}; 
	
	public abstract void move(Point p);
}
