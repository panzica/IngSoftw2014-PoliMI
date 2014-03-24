package es2;

public class TextualTwoDimensionalCanvas implements TwoDimensionalCanvas{

	@Override
	public void drawPoint(Point point) {
		System.out.println("drawing point: " + point);
		
	}

	@Override
	public void drawLine(Point firstEndPoint, Point secondEndPoint) {
		System.out.println("drawing Line from: " + 
	firstEndPoint + " to: " + secondEndPoint);
		
	}

	@Override
	public void drawCircle(Point center, double radius) {
		System.out.println("drawing circle with center: " + 
	center + " and radius: " + radius);
		
	}

}
