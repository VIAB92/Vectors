package Vectors;

import Exceptioner.IncompatibleVectorSizesException;
import Iterators.VectorIterator;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Victor Rotar
 * Date: 06.11.13
 * Time: 20:59
 * To change this template use File | Settings | File Templates.
 */
public class SynchronizedVector implements Vector, Iterable {

    private Vector myVector;

    public SynchronizedVector(Vector sourceVector)
    {
        this.myVector=sourceVector;
    }

    @Override
    public synchronized double getElement(int index) {
       return myVector.getElement(index);
    }

    @Override
    public synchronized void setElement(int index, double value) {
       this.myVector.setElement(index, value);
    }

    @Override
    public synchronized int getSize() {
        return this.myVector.getSize();
    }

    @Override
    public synchronized void printVector() {
        this.printVector();
    }

    @Override
    public synchronized void multiplyOn(double value) {
        this.myVector.multiplyOn(value);
    }

    @Override
    public synchronized void fillFromArray(double[] arr) {
        this.myVector.fillFromArray(arr);
    }

    @Override
    public synchronized void fillFromVector(Vector vector) {
        this.myVector.fillFromVector(vector);
    }

    @Override
    public synchronized void sumWithVector(Vector anotherVector) throws IncompatibleVectorSizesException {
       this.myVector.sumWithVector(anotherVector);
    }

    @Override
    public synchronized boolean compareWithVector(Vector anotherVector) {
        return this.compareWithVector(anotherVector);
    }

    public synchronized String toString()
    {
        StringBuffer myString = new StringBuffer();
        for (int i=0; i<this.getSize(); i++)
            myString.append(this.getElement(i)+" ");
        return myString.toString();
    }

    public synchronized boolean equals(Object obj)
    {
        Vector myVector = null;
        if (!(obj instanceof Vector))
            return false;
        myVector = (Vector)obj;
        if (!this.compareWithVector(myVector))
            return false;
        return true;
    }

    public synchronized int hashCode()
    {
        int result = 0;
        for (int i=0; i<this.getSize(); i++)
        {
            long bits = Double.doubleToRawLongBits(this.getElement(i));
            result^=((int)(bits & 0x00000000FFFFFFFFL)) ^ ((int)((bits & 0xFFFFFFFF00000000L) >> 32));
        }
        return result;
    }

    public synchronized Object clone() throws CloneNotSupportedException
    {
        Vector newv = (ArrayVector)super.clone();
        newv.fillFromVector(this);
        return newv;
    }


    @Override
    public Iterator iterator() {
        return new VectorIterator(this);
    }
}
