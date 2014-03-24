package es2;

public class ShapeClient {
	public static void main(String[] args){
		Shape s1 = new Square(new Point(0,0), 0 ,10);
		Shape s2 = new Circle(new Point(0,0),5);
		TwoDimensionalCanvas canvas = new TextualTwoDimensionalCanvas();
		s1.draw(canvas);
		s2.draw(canvas);
	}

}
