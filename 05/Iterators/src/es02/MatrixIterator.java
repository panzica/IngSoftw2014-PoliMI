package es02;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Float> {
    private Matrix matrix;
    private int currentRow = 1, currentColumn = 1;
    public MatrixIterator(Matrix matrix) {
         this.matrix = matrix;
    }
    @Override
    public boolean hasNext() {
         return currentRow <= matrix.rows();
    }
    @Override
    public Float next() {
         float element = matrix.element(currentRow, currentColumn);
         currentColumn++;
         if (currentColumn > matrix.columns()) {
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