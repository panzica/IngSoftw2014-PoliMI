package es02;

public class DemoIteratori {
	public static void main(String args[]) {
	       Matrix matrix = new Matrix(2, 2);
	   
	       MatrixIterator iterator = new MatrixIterator(matrix);
	       System.out.println("Iterator Separato");
	       while (iterator.hasNext()) {
	          float f = iterator.next();
	          System.out.println(f);
	       }
	       System.out.println("Iterator Embedded");
	       for(float f : matrix){
	          System.out.println(f);
	       }
	}

}
