package Factories;

import Vectors.LinkedListVector;
import Vectors.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Victor Rotar
 * Date: 23.10.13
 * Time: 20:50
 * To change this template use File | Settings | File Templates.
 */
public class LinkedListVectorFactory implements VectorFactory {
    @Override
    public Vector createVector() {
        Vector linkedVector = new LinkedListVector();
        return linkedVector;

    }

    @Override
    public Vector createVector(int length) {
        double[] arr = new double[length];
        for(int i=0; i<length; i++)
        {
            arr[i]=0;
        }
        Vector linkedVector = new LinkedListVector(arr);
        return linkedVector;
    }
}
