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
public class LinkedListVector extends ObservableVector implements Vector, Iterable{
    private int count=0;
    @Override
    public Iterator iterator() {
        return new VectorIterator(this);
    }

    /*Отдельные элементы списка*/
    class Element implements Cloneable, Serializable
    {
        private double value;

        private Element next;
        private Element prev;

        public double getValue()
        {
            return value;
        }

        public void setValue(double val)
        {
            value=val;
        }

        public Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    private int length;
    public Element iFirst;          //первый элемент вектора

    public LinkedListVector(){}
    /*Конструктор создания одномерного вектора*/
    public LinkedListVector(double value)
    {
        length=1;
        iFirst = new Element();
        iFirst.setValue(value);
        iFirst.next=iFirst;
        iFirst.prev=iFirst;
    }

    /*Конструктор для вектора длиной больше единицы*/
    public LinkedListVector(double ... array)
    {
        length=array.length;

        iFirst = new Element();
        iFirst.setValue(array[0]);

        Element iTemp, iInherim;            //временные ссылки для построения
        iTemp = iFirst;

        for (int i=1; i<array.length; i++)
        {
            iTemp.next = new Element();
            iInherim = iTemp;
            iTemp = iTemp.next;
            iTemp.prev=iInherim;
            iTemp.setValue(array[i]);
        }

        iTemp.next=iFirst;                  //ну циклический же!!!
        iFirst.prev=iTemp;
    }

    /*Конструктор заполнения вектора из другого вектора*/
    public LinkedListVector(Vector anotherVector)
    {
        length = anotherVector.getSize();
        iFirst = new Element();
        iFirst.setValue(anotherVector.getElement(0));

        Element iTemp, iInherim;
        iTemp = iFirst;
        for (int i=1; i<anotherVector.getSize(); i++)
        {
            iTemp.next = new Element();
            iInherim = iTemp;
            iTemp = iTemp.next;
            iTemp.prev=iInherim;
            iTemp.setValue(anotherVector.getElement(i));
        }

        iTemp.next=iFirst;
        iFirst.prev=iTemp;
    }

    /*Добавление нового элемента в конец списка*/
    public void addElement(double value)
    {
        Element iTemp, iLast;
        iLast = iFirst.prev;

        iTemp = new Element();
        iTemp.setValue(value);

        iLast.next=iTemp;
        iTemp.prev=iLast;
        iTemp.next=iFirst;

        length++;

    }

    /*Удаление элемента по его порядковому номеру в списке*/
    public void deleteElement(int index)
    {
        if (index>=length)
        {
            System.out.println("Vector Index is out of range");
            return;
        }

        if(length==1)
        {
            System.out.println("Элемент в списке один! Вектор не может иметь нулевую размерность");
            return;
        }

        Element iDoomed, iTemp, iInterim;
        if (index==0)
        {
            iDoomed = iFirst;
            iFirst = iFirst.next;
            iFirst.prev = iDoomed.prev;
        }
        else
        {
            iDoomed = iFirst;
            for (int i=1 ; i <= index ; i++)
                iDoomed = iDoomed.next;

            iTemp = iDoomed.prev;
            iInterim = iDoomed.next;

            iTemp.next = iInterim;
            iInterim.prev = iTemp;
        }
        length--;
        notifyObserver("vector");
    }

    //получаем элемент по индексу
    public double getElement(int index)
    {
        if (index>=length)
            System.out.println("Вы пытаетесь получить элемент, больший длины вектора");
        Element iTemp = iFirst;
        for (int i=1; i<=index; i++) iTemp = iTemp.next;
        return iTemp.getValue();
    }

    //изменяем элемент по индексу
    public void setElement(int index, double value)
    {
        if (index>=length)
        {
            System.out.println("Вы пытаетесь изменить элемент, больший размера вектора");

        }
        Element iTemp = iFirst;
        for (int i=1; i<=index; i++) iTemp = iTemp.next;
        iTemp.setValue(value);
        element=index;
        notifyObserver("element");
    }

    //получаем длину вектора
    public int getSize()
    {
        return length;
    }

    public void printVector()
    {
        for (int i=0; i<length; i++)
        {
            System.out.println(getElement(i)+" ");
        }
        System.out.println();
    }

    //Сравнение двух векторов
    public boolean compareWithVector(Vector anotherVector)
    {

        if (this.getSize() != anotherVector.getSize())
            return false;
        for (int i=0; i<anotherVector.getSize(); i++)
        {
            if (this.getElement(i) != anotherVector.getElement(i))
                return false;
            else
                continue;
        }
        return true;
    }

    //Сложение двух векторов
    public void sumWithVector(Vector anotherVector) throws IncompatibleVectorSizesException {

        if (this.getSize() !=anotherVector.getSize())
        {
            throw new IncompatibleVectorSizesException("Ошибка суммирования!");
        }
        else
        {
            for (int i=0; i<anotherVector.getSize(); i++)
            {
                this.setElement(i, this.getElement(i)+anotherVector.getElement(i));
            }
            System.out.println("Сложение вектором прошло успешно!");
            this.printVector();
        }
        notifyObserver("vector");
    }

    /*Умножение вектора на скаляр*/
    public void multiplyOn(double value)
    {
        for (int i=0; i<this.getSize(); i++)
        {
            this.setElement(i, this.getElement(i)*value);
        }
        System.out.println("Умножение вектора на скаляр прошло успешно!");
        this.printVector();
        notifyObserver("vector");
    }

    @Override
    public void fillFromArray(double[] arr) {
        iFirst=null;
        length=0;
        length=arr.length;

        iFirst = new Element();
        iFirst.setValue(arr[0]);

        Element iTemp, iInherim;            //временные ссылки для построения
        iTemp = iFirst;

        for (int i=1; i<arr.length; i++)
        {
            iTemp.next = new Element();
            iInherim = iTemp;
            iTemp = iTemp.next;
            iTemp.prev=iInherim;
            iTemp.setValue(arr[i]);
        }

        iTemp.next=iFirst;
        iFirst.prev=iTemp;
        notifyObserver("vector");
    }

    @Override
    public void fillFromVector(Vector vector) {
        iFirst=null;
        length=0;
        length = vector.getSize();
        iFirst = new Element();
        iFirst.setValue(vector.getElement(0));

        Element iTemp, iInherim;
        iTemp = iFirst;
        for (int i=1; i<vector.getSize(); i++)
        {
            iTemp.next = new Element();
            iInherim = iTemp;
            iTemp = iTemp.next;
            iTemp.prev=iInherim;
            iTemp.setValue(vector.getElement(i));
        }

        iTemp.next=iFirst;
        iFirst.prev=iTemp;
        notifyObserver("vector");
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

        LinkedListVector newVector = (LinkedListVector)super.clone();


        newVector.fillFromVector(this);

        return newVector;
    }

}
