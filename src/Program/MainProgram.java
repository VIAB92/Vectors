/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Exceptioner.IncompatibleVectorSizesException;
import Exceptioner.VectorIndexOutOfBoundsException;
import ObservRealization.VectorManager;
import Vectors.*;

import Factories.ArrayVectorFactory;
import Factories.LinkedListVectorFactory;
import Factories.VectorFactory;
import Vectors.Vector;

import java.io.*;


/**
 *
 * @author Victor Rotar
 */
public class MainProgram {
    public static void main(String[] args) throws  IncompatibleVectorSizesException {
       /*
         ArrayVector av = new ArrayVector(1.3,9.5,7.5,9.4);
        ArrayVector av2 = new ArrayVector(1.3);
       // av.sumWithVector(av2);
        try
        {
            for (int i=0; i<50; i++)
                if (i<av.getSize()) System.out.println("OK");
                else
                    throw new VectorIndexOutOfBoundsException("Элемент вне массива");
        }
        catch(VectorIndexOutOfBoundsException ex)
        {

            ex.printStackTrace();
        }   */

        /*ЗАДАНИЕ 1:*/
      /*  Vector newVector = Vectors.createInstance(10);
        Vector v2 = Vectors.createInstance(5);
        Vector v3 = Vectors.createInstance(7);
        WriteVector wv = new WriteVector(newVector);
        ReadVector rw = new ReadVector(newVector);
        WriteVector wv2 = new WriteVector(v2);
        ReadVector rv2 = new ReadVector(v2);
        WriteVector wv3 = new WriteVector(v3);
        ReadVector rv3 = new ReadVector(v3);
          rw.setPriority(Thread.MAX_PRIORITY);
        wv.setPriority(Thread.MIN_PRIORITY);
        rv2.setPriority(Thread.MAX_PRIORITY);
        wv.start();
        rw.start();
        wv2.start();
        rv2.start();
        wv3.start();
        rv3.start();*/
        Vector newVector = Vectors.createInstance(5);
        SyncHelper sh = new SyncHelper(newVector);
        new VectorWriter(sh);
        new VectorReader(sh);




    }
}
