package es2;

import java.util.ArrayList;
import java.util.List;

public class Square extends Shape{

	private final Point initialPoint;
	// It represents the orientation, in radiant degrees of the square
	private final double orientation;
	private final double sideLength;

	public Square(Point initialPoint, double orientation, double sideLength) {
		if (initialPoint == null || sideLength < 0 || orientation < 0 || orientation > 2 * Math.PI) {
			throw new IllegalArgumentException();
		}
		this.initialPoint = initialPoint;
		this.orientation = orientation;
		this.sideLength = sideLength;
	}

	@Override
	public double getArea() {
		return sideLength * sideLength;
	}

	@Override
	public double getPerimeter() {
		return 4 * sideLength;
	}

	@Override
	public List<Point> getSequenceOfPointsToDraw() {
		List<Point> points = new ArrayList<Point>();
		points.add(initialPoint);
		Point nonOrientedSecondPoint = new Point(initialPoint.getX(), initialPoint.getY() + sideLength);
		points.add(nonOrientedSecondPoint.rotate(initialPoint, orientation));
		Point nonOrientedThirdPoint = new Point(initialPoint.getX() + sideLength, initialPoint.getY() + sideLength);
		points.add(nonOrientedThirdPoint.rotate(initialPoint, orientation));
		Point nonOrientedFourthPoint = new Point(initialPoint.getX() + sideLength, initialPoint.getY());
		points.add(nonOrientedFourthPoint.rotate(initialPoint, orientation));
		return points;
	}
}
