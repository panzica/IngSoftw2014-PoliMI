package es2;

import java.util.ArrayList;
import java.util.List;

public class Circle extends Shape{
	private final Point center;
	private final double radius;

	public Circle(Point center, double radius) {
		if (center == null || radius < 0) {
			throw new IllegalArgumentException();
		}
		this.center = center;
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public List<Point> getSequenceOfPointsToDraw() {
		// Primo approccio: 
		// Approssimiamo il cerchio con una figura regolare con 256 lati
		List<Point> points = new ArrayList<Point>();
		int numberOfSegments = 256;
		for (int i = 0; i < numberOfSegments; i++) {
			double newPointX = center.getX() + radius * Math.cos(2 * Math.PI * i / numberOfSegments);
			double newPointY = center.getY() + radius * Math.sin(2 * Math.PI * i / numberOfSegments);
			points.add(new Point(newPointX, newPointY));
		}
		return points;
	}

	@Override
	public void draw(TwoDimensionalCanvas canvas) {
		/* Secondo approccio: overriding di draw
		 * Seguendo questo approccio, possiamo utilizzare le primitive per
		 * disegnare messe a disposizione dal piano. L'introduzione di una nuova
		 * forma richiede un minor numero di modifiche al codice.
		 */
		canvas.drawCircle(center, radius);
	}

}
