/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vectors;

/**
 *
 * @author user
 */
public interface Vector {
    double getElement(int index);
    void setElement(int index, double value);
    int getSize();
    void printVector();
    boolean compareWithVector(Vector anotherVector);
    void sumWithVector(Vector anotherVector);
    void multiplyOn(double value);
    void fillFromArray(double[] arr);
    void fillFromVector(Vector vector);


}
