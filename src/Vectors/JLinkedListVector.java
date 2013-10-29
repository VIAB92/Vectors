package Vectors;
import Iterators.VectorIterator;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 15.10.13
 * Time: 15:06
 * To change this template use File | Settings | File Templates.
 */
public class JLinkedListVector extends ObservableVector implements Vector, Iterable {
    LinkedList<Double> myList;
    private int count=0;

    public JLinkedListVector() {}

    public JLinkedListVector(double ... params)
    {
        myList = new LinkedList<Double>();
        for(double val:params)
        {
            myList.add(val);
        }
    }

    public JLinkedListVector(Vector anotherVector)
    {
        myList = new LinkedList<Double>();
        for(int i=0; i<anotherVector.getSize(); i++)
        {
            myList.add(anotherVector.getElement(i));
        }
    }

    @Override
    public double getElement(int index) {
        return myList.get(index);
    }

    @Override
    public void setElement(int index, double value) {
        myList.set(index, value);
        element=index;
        notifyObserver("element");

    }

    @Override
    public int getSize() {
        return myList.size();
    }

    @Override
    public void printVector() {
        for(double val:myList)
        {
            System.out.print(val+" ");
        }
        System.out.println();
    }

    @Override
    public void multiplyOn(double value) {
        for(int i=0; i<this.getSize(); i++)
        {
            this.setElement(i, this.getElement(i)*value);
        }
        notifyObserver("vector");
    }

    @Override
    public void fillFromArray(double[] arr) {
        myList=null;
        myList = new LinkedList<Double>();
        for(double val:arr)
        {
            myList.add(val);
        }
        notifyObserver("vector");
    }

    @Override
    public void fillFromVector(Vector vector) {
        myList=null;
        myList = new LinkedList<Double>();
        for(int i=0; i<vector.getSize(); i++)
        {
            myList.add(vector.getElement(i));
        }
        notifyObserver("vector");
    }

    @Override
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
            notifyObserver("vector");
        }
    }

    @Override
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
