package Vectors;

import Iterators.VectorIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 15.10.13
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public class JArrayListVector implements Vector, Iterable{
    private ArrayList<Double> myList;
    private int count=0;

    public JArrayListVector() {}

    public JArrayListVector(double ... params)
    {
        myList = new ArrayList<Double>();
        for(double param:params)
        {
            myList.add(param);
        }
    }

    public JArrayListVector(Vector anotherVector)
    {
        myList = new ArrayList<Double>();
        for(int i=0; i<anotherVector.getSize(); i++)
        {
            myList.add(anotherVector.getElement(i));
        }
    }

    public double getElement(int index) {
        return myList.get(index);
    }

    public void setElement(int index, double value) {
       myList.set(index, value);
    }

    public int getSize() {
        return myList.size();
    }

    public void printVector() {
        for(double val:myList)
            System.out.print(val+" ");
        System.out.println();
    }

    public void multiplyOn(double value) {
        for(int i=0; i<this.getSize(); i++)
        {
            this.setElement(i, this.getElement(i)*value);
        }
    }

    public void fillFromArray(double[] arr) {
        myList=null;
        myList = new ArrayList<Double>();
        for(double value:arr)
        {
            myList.add(value);
        }
    }

    public void fillFromVector(Vector vector) {
        myList=null;
        myList = new ArrayList<Double>();
        for(int i=0; i<vector.getSize(); i++)
        {
            myList.add(vector.getElement(i));
        }
    }

    public void sumWithVector(Vector anotherVector) {
        if (this.getSize()!=anotherVector.getSize())
        {
            System.out.println("Размеры векторов не совпадают. Ошибка суммирования!");
        }
        else
        {
            for(int i=0; i<anotherVector.getSize(); i++)
            {
                this.setElement(i, this.getElement(i)+anotherVector.getElement(i));
            }
            System.out.println("Сложение векторов прошло успешно!");
            this.printVector();
        }
    }

    public boolean compareWithVector(Vector anotherVector) {
        if (this.getSize() != anotherVector.getSize())
            return false;
        for(int i=0; i<anotherVector.getSize(); i++)
        {
            if (this.getElement(i) != anotherVector.getElement(i))
                return false;
            else
                continue;
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        return new VectorIterator(this);
    }

    public String toString()
    {
        StringBuffer myString = new StringBuffer();
        for (int i=0; i<this.getSize(); i++)
            myString.append(this.getElement(i)+" ");
        return myString.toString();
    }
}
