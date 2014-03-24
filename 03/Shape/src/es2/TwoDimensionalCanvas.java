package es2;

public interface TwoDimensionalCanvas {
	void drawPoint(Point point);

	void drawLine(Point firstEndPoint, Point secondEndPoint);

	void drawCircle(Point center, double radius);
}