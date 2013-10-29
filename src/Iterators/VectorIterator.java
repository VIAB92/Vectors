package Iterators;

import Vectors.Vector;

import java.util.Iterator;


public class VectorIterator implements Iterator {
    Vector vector;
    int position = 0;

    public VectorIterator(Vector vector)
    {
        this.vector=vector;
    }

    @Override
    public boolean hasNext() {
        if (position>=vector.getSize()) return false;
        else
            return true;
    }

    @Override
    public Object next() {
        return vector.getElement(position++);
    }

    @Override
    public void remove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
