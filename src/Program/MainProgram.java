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
        }

    }
}
