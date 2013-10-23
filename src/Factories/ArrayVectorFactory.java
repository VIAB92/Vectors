package Factories;

import Vectors.ArrayVector;
import Vectors.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Victor Rotar
 * Date: 23.10.13
 * Time: 20:41
 * To change this template use File | Settings | File Templates.
 */
public class ArrayVectorFactory implements VectorFactory {
    @Override
    public Vector createVector() {
        Vector arrayVector = new ArrayVector();
        return arrayVector;
    }

    @Override
    public Vector createVector(int length) {
        double[] arr = new double[length];
        for(int i=0; i<length; i++) arr[i]=0;
        Vector arrayVector = new ArrayVector(arr);
        return arrayVector;
    }
}
