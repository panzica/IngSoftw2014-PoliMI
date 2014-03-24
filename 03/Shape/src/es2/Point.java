package es2;

public class Point {
	private final double x;
	private final double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Point rotate(Point center, double degrees) {
		double rotatedX = center.x + (x - center.x) * Math.cos(degrees) - (y - center.y) * Math.sin(degrees);
		double rotatedY = center.y + (x - center.x) * Math.sin(degrees) + (y - center.y) * Math.cos(degrees);
		return new Point(rotatedX, rotatedY);
	}
	
	public String toString(){
		return "x = " + x + " y = " + y;
	}
}
