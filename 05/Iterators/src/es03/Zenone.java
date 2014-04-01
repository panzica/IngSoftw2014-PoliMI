package es03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Zenone implements Iterator<Double> {
    private double distanceToCover;
    public Zenone(double distanceToCover) {
        this.distanceToCover = distanceToCover;
}
@Override
    public boolean hasNext() {
        return distanceToCover > 0;
}
@Override
    public Double next() {
        if (distanceToCover <= 0)
            throw new NoSuchElementException();
        distanceToCover /= 2;
        return distanceToCover;
}
@Override
    public void remove() {
        throw new UnsupportedOperationException();
} }