package es02;

import java.util.Iterator;

public class Matrix implements Iterable<Float>{
	private float [][] A;	
	private int rows;
	private int columns;
	
	public Matrix(int rows,int columns){
		//TODO inserire le dovute eccezioni
		this.rows = rows;
		this.columns = columns;
		A = new float[rows][columns];
	}
	public int rows(){ 
		return rows;
	}
    public int columns(){ 
    		return columns;
    }
    public float element(int row, int column){
    		//TODO inserire le dovute eccezioni e controlli
    		return A[row-1][column-1];
    	
    }
    
    
    private class MatrixIterator2 implements Iterator<Float> {
        private int currentRow = 1;
        private int currentColumn = 1;
        
	    @Override
	    public boolean hasNext() {
	        return currentRow <= rows();
	    }
	    @Override
	    public Float next() {
	        float element = element(currentRow, currentColumn);
	        currentColumn++;
	        if (currentColumn > columns()) {
	            currentColumn = 1;
	            currentRow++;
	        }
	        return element;
	    }
		@Override
	    public void remove() throws UnsupportedOperationException {
	        throw new UnsupportedOperationException();
		} 
	}

	@Override
	public Iterator<Float> iterator() {
		
		return new MatrixIterator2();
	}

}
