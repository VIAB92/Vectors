package Proxies;

import Vectors.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Victor Rotar
 * Date: 29.10.13
 * Time: 8:12
 * To change this template use File | Settings | File Templates.
 */
public class ProtectedVector implements Vector {
    Vector vect;

    public ProtectedVector(Vector vector)
    {
        this.vect=vector;
    }

    @Override
    public double getElement(int index) {
       return vect.getElement(index);
    }

    @Override
    public void setElement(int index, double value) {
       System.out.println("В данном классе нельзя изменять значения");
    }

    @Override
    public int getSize() {
        return vect.getSize();
    }

    @Override
    public void printVector() {
       vect.printVector();
    }

    @Override
    public boolean compareWithVector(Vector anotherVector) {
        return vect.compareWithVector(anotherVector);
    }

    @Override
    public void sumWithVector(Vector anotherVector) {
        vect.sumWithVector(anotherVector);
    }

    @Override
    public void multiplyOn(double value) {
        vect.multiplyOn(value);
    }

    @Override
    public void fillFromArray(double[] arr) {
        vect.fillFromArray(arr);
    }

    @Override
    public void fillFromVector(Vector vector) {
        vect.fillFromVector(vector);
    }
}
