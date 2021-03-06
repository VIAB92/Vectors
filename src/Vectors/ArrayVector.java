/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vectors;

import Exceptioner.IncompatibleVectorSizesException;
import Iterators.VectorIterator;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class ArrayVector extends ObservableVector implements Vector,  Iterable{
    private double[] myVector;
    private int count = 0;

    public ArrayVector(double ... anotherVector)
    {
        this.myVector = new double[anotherVector.length];
        for (int i=0; i<anotherVector.length; i++)
        {
            myVector[i] = anotherVector[i];
        }
    }
    public ArrayVector(){}
    //Заполнение вектора из другого вектора
    public ArrayVector(Vector anotherVector)
    {
        this.myVector = new double[anotherVector.getSize()];
        for(int i=0; i<anotherVector.getSize(); i++)
        {
            myVector[i] = anotherVector.getElement(i);
        }
    }

    //Получение значения вектора
    public double getElement(int index)
    {
        return this.myVector[index];
    }

    //Установка значения вектора
    public void setElement(int index, double value)
    {
        this.myVector[index] = value;
        element=index;
        notifyObserver("element");
    }

    //Получение длины вектора
    public int getSize()
    {
        return this.myVector.length;
    }

    //Сравнение двух векторов
    public boolean compareWithVector(Vector anotherVector)
    {

        if (this.myVector.length != anotherVector.getSize())
            return false;
        for(int i=0; i<anotherVector.getSize(); i++)
        {
            if (myVector[i] != anotherVector.getElement(i))
                return false;
            else
                continue;
        }
        return true;
    }

    //Сложение двух векторов
    public void sumWithVector(Vector anotherVector) throws IncompatibleVectorSizesException {
        if (myVector.length != anotherVector.getSize())
        {
           throw new IncompatibleVectorSizesException("Ошибка суммирования");
        }
        else
        {
            for (int i=0; i<myVector.length; i++)
            {
                myVector[i]+=anotherVector.getElement(i);
            }

            System.out.println("Сложение векторов прошло успешно!");
            this.printVector();
            notifyObserver("vector");
        }
    }


    //Умножение двух векторов
    public void multiplyOn(double value)
    {
        for (int i=0; i<myVector.length; i++)
        {
            myVector[i] *= value;
        }
        this.printVector();
        notifyObserver("vector");
    }

    @Override
    public void fillFromArray(double[] arr) {
        this.myVector=null;

        this.myVector = new double[arr.length];
        for (int i=0; i<arr.length; i++)
        {
            myVector[i] = arr[i];
        }
        notifyObserver("vector");

    }

    @Override
    public void fillFromVector(Vector vector) {

        this.myVector=null;
        this.myVector = new double[vector.getSize()];
        for(int i=0; i<vector.getSize(); i++)
        {
            myVector[i] = vector.getElement(i);
        }
        notifyObserver("vector");
    }

    public void printVector()
    {
        System.out.println("Ваш вектор:");
        for (double val:myVector)
        {
            System.out.print(val+" ");
        }
        System.out.println();
    }

    public String toString()
    {
        StringBuffer myString = new StringBuffer();
        for (int i=0; i<this.getSize(); i++)
            myString.append(this.getElement(i)+" ");
        return myString.toString();
    }

    public boolean equals(Object obj)
    {
        Vector myVector = null;
        if (!(obj instanceof Vector))
            return false;
        myVector = (Vector)obj;
        if (!this.compareWithVector(myVector))
            return false;
        return true;
    }

    public int hashCode()
    {
        int result = 0;
        for (int i=0; i<this.getSize(); i++)
        {
            long bits = Double.doubleToRawLongBits(this.getElement(i));
            result^=((int)(bits & 0x00000000FFFFFFFFL)) ^ ((int)((bits & 0xFFFFFFFF00000000L) >> 32));
        }
        return result;
    }

    public Object clone() throws CloneNotSupportedException
    {
        ArrayVector newv = (ArrayVector)super.clone();

        return newv;
    }


    @Override
    public Iterator iterator() {
        return new VectorIterator(this);
    }

}
