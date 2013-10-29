/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Vectors.Vector;

import Factories.ArrayVectorFactory;
import Factories.LinkedListVectorFactory;
import Factories.VectorFactory;
import Vectors.ArrayVector;
import Vectors.JLinkedListVector;
import Vectors.LinkedListVector;
import Vectors.Vector;

import java.io.*;


/**
 *
 * @author Victor Rotar
 */
public class MainProgram {
    public static void main(String[] args) throws CloneNotSupportedException, IOException {/*
        double[] array ={1.5f, 1.6f, 2.3f, 0.9f, -0.5f, 27f, 26f, 3723f, 0, 27.1f};

        Vector vect = new Vector(array);
        System.out.println("MAX = " + vect.getMax());
        System.out.println("MIN = " + vect.getMin());
        System.out.println("Value 2 = " + vect.getValue(2));
        vect.printVector();

         double[] array2 ={1.5f, 1.6f, 2.3f, 0.9f, -0.5f, 27f, 26f, 3723f, 0, 27.1f};
         Vector v2 = new Vector(array2);
         if (vect.compareWithVector(v2))
             System.out.println("Векторы совпадают!");
         else
             System.out.println("Векторы не совпадают!");
         vect.sumWithVector(v2);
        // vect.sort();
        */

        double[] arr = {1.5, 3.6, 0.7, 2.9};
        LinkedListVector myVector = new LinkedListVector(arr);
        myVector.printVector();
        System.out.println("Element 2: " + myVector.getElement(1));
        System.out.println("Размер списка: "+myVector.getSize());
        myVector.deleteElement(1);
        System.out.println("После удаления 2 элемента:");

        myVector.printVector();
        System.out.println("Создаём новый вектор, равный исходному");
        ArrayVector vect2 = new ArrayVector(myVector);
        System.out.println("Новый ArrayVector:");
        vect2.printVector();
        System.out.println("Равны ли объекты?");
        boolean b = vect2.compareWithVector(myVector);
        System.out.println(b);
        System.out.println("Удаление головы списка:");
        myVector.deleteElement(0);
        myVector.printVector();
        System.out.println("Теперь первый элемент: "+myVector.getElement(0));
        //сортировка
        Vectors.Vectors.sort(vect2);
        System.out.println("Использование toString()");
        System.out.println(vect2.toString());
        System.out.println("Равны ли вектора по equals()?");
        LinkedListVector newVect = new LinkedListVector(vect2);
        System.out.println(newVect.equals(vect2));
      /* ArrayVector cloned = (ArrayVector)vect2.clone();
       cloned.toString();*/
      /* ArrayVector clonedLink = (ArrayVector)vect2.clone();
       System.out.println(clonedLink.toString());*/
        LinkedListVector vvv = (LinkedListVector)myVector.clone();
        System.out.println("И снова первый элемент:" + vvv.getElement(0));
        System.out.println("Hashcode myVector: "+myVector.hashCode());
        System.out.println("Hashcode vvv: "+vvv.hashCode());
        System.out.println("myVector's iFirst: "+myVector.iFirst);
        System.out.println("vvv's iFirst: "+vvv.iFirst);

        System.out.println("Проверка части второй:");
        JLinkedListVector vct = new JLinkedListVector(new double[] {1.9, 2.3, 0.65, 5, 9.8, 10.22, 0});
        for(Object val:vct)
            System.out.println(val);
        System.out.println("Генерация вектора:");
        Vector vector_gen = Vectors.Vectors.createRandomVector(7);
        vector_gen.printVector();

        //Проверка записи в байтовый поток
        OutputStream f0 = new FileOutputStream("file1.txt");
        Vectors.Vectors.outputVector(vector_gen, f0);
         f0.close();
        InputStream fInp = new FileInputStream("file1.txt");
        Vector vect = Vectors.Vectors.inputVector(fInp);
        fInp.close();
        System.out.println("Считайнный из файла вектор TEST inputVector():");
        vect.printVector();

        //Проверка записи в символьный поток
        FileWriter fw = new FileWriter("file2.txt");
        Vectors.Vectors.writeVector(vector_gen, fw);
        fw.close();
        FileReader rdr = new FileReader("file2.txt");
        Vector vect1 = Vectors.Vectors.readVector(rdr);
        System.out.println("Проверка readVector():");
        vect.printVector();
        System.out.println("Проверка сериализации:");
        //сериализация
        try
        {
            FileOutputStream fos = new FileOutputStream("serial");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(vect1);
            oos.flush();
            oos.close();
            System.out.println("Serialized");
        }
        catch(Exception e)
        {
            System.out.println("Исключение во время сериализации: " + e);
            System.exit(0);
        }

        System.out.println("Проверка десериализации:");
        //десериализация
        try
        {
            Vector vector_des;
            FileInputStream fis = new FileInputStream("serial");
            ObjectInputStream ois = new ObjectInputStream(fis);
            vector_des = (Vectors.Vector)ois.readObject();
            ois.close();
            vector_des.printVector();
        }
        catch (Exception e)
        {
            System.out.println("Ошибка десериализации: "+e);
            System.exit(0);
        }

        System.out.println("Проверка фабричного метода");
        VectorFactory vf = new LinkedListVectorFactory();
        Vectors.Vectors.setVectorFactory(vf);
        Vector myNewMade = Vectors.Vectors.createInstance(10);
        myNewMade.printVector();
        System.out.println("Вектор принадлежит классу: "+myNewMade.getClass());
        vf = new ArrayVectorFactory();
        Vectors.Vectors.setVectorFactory(vf);
        myNewMade = Vectors.Vectors.createInstance(5);
        myNewMade.printVector();
        System.out.println("А теперь вектор принадлежит классу: "+myNewMade.getClass());


        System.out.println("Проверка адаптера:");
        java.util.Vector<Double> mynewv = new java.util.Vector<Double>();
        mynewv.add(13.2);
        mynewv.add(14.5);
        Vector adapt = Vectors.Vectors.getAdaptedVector(mynewv);
        boolean bol = adapt instanceof Vector;
        System.out.println("Принадлежит ли adapt интерфейсу Vector? - "+bol);
        System.out.println("Проверка заместителя:");
        Vector prot = Vectors.Vectors.getProtectedVector(adapt);
        prot.setElement(0, 12);
    }
}
