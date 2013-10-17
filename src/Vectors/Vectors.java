/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vectors;

import Sorters.Sorter;

import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.ArrayList;
/**
 *
 * @author user
 */
public class Vectors {
    //Умножение на скаляр
    public static Vector multiplyVectorOn(Vector myVector, double value)
    {
         Vector vect = new LinkedListVector(myVector);
        for (int i=0; i<myVector.getSize(); i++)
        {
            vect.setElement(i, myVector.getElement(i)*value);

        }
        return vect;
    }

    //сложение векторов
    public static Vector sumVectors(Vector myVector, Vector anotherVector)
    {
        if (myVector.getSize() != anotherVector.getSize())
        {
            System.out.println("Длины векторов не совпадают!");
             return null;
        }
        else
        {
            Vector vect = new LinkedListVector(myVector);
            for (int i=0; i<myVector.getSize(); i++)
            {
                vect.setElement(i, vect.getElement(i)+anotherVector.getElement(i));
            }

            System.out.println("Сложение векторов прошло успешно!");
            return vect;
        }
    }

    public static Vector createRandomVector(int n)
    {
        double[] array = new double[n];
        Random randomGenerator = new Random();
        for(int i=0; i<n; i++)
        {
            double value = randomGenerator.nextDouble();
            array[i]=value;
        }
        Vector vect = new JLinkedListVector();
        vect.fillFromArray(array);
        return vect;
    }
    //Сортировка вектора
    public static void sort(Vector vector)
    {
        Sorter s = new Sorter();
        s.sortByAsc(vector);
        System.out.println("ПОСЛЕ СОРТИРОВКИ");
        vector.printVector();
    }

    //запись вектора в байтовый поток
    public static void outputVector(Vector v, OutputStream out) throws IOException {
        String vectorString = v.toString();
        byte buf[] = vectorString.getBytes();
        out.write(buf);
    }
    //чтение из байтового потока
    public static Vector inputVector(InputStream in) throws IOException {
        int content;
        StringBuffer stringBuf = new StringBuffer();

        while((content=in.read())!=-1)
        {
                char symbol = (char)content;
            stringBuf.append(symbol);
        }
        String str = stringBuf.toString();
        StringTokenizer st = new StringTokenizer(str, " ");

        ArrayList<Double> vals = new ArrayList();
        while (st.hasMoreTokens())
        {
            vals.add(Double.parseDouble(st.nextToken()));
        }
        double[] array = new double[vals.size()];
        for(int i =0; i<vals.size(); i++)
        {
            array[i]=vals.get(i);
        }
        Vector myVector = new JLinkedListVector(array);
        return myVector;


    }

    //запись в символьный поток
    public static void writeVector(Vector v, Writer out) throws IOException {
        String vectorString = v.toString();
        char buffer[] = new char[vectorString.length()];
        vectorString.getChars(0, vectorString.length(), buffer, 0);
        out.write(buffer);

    }

    public static Vector readVector(Reader in) throws IOException {
        String s;
        StringBuffer stringBuf = new StringBuffer();
        BufferedReader br = new BufferedReader(in);
        while((s=br.readLine())!=null)
        {
                stringBuf.append(s);
        }
        String str = stringBuf.toString();
        StringTokenizer st = new StringTokenizer(str, " ");

        ArrayList<Double> vals = new ArrayList();
        while (st.hasMoreTokens())
        {
            vals.add(Double.parseDouble(st.nextToken()));
        }
        double[] array = new double[vals.size()];
        for(int i =0; i<vals.size(); i++)
        {
            array[i]=vals.get(i);
        }
        Vector myVector = new JLinkedListVector(array);
        return myVector;

    }


}
