/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorters;

import Vectors.Vector;
import Vectors.ArrayVector;
//import Vectors.Vector;

/**
 *
 * @author Victor Rotar
 */
public  class Sorter {
    public void sortByAsc(Vector v)
    {
        int n = v.getSize();
        for (int i=0; i<n-1; i++)
            for (int j=0; j<n-i-1; j++)
                if (v.getElement(j)>v.getElement(j+1))
                {
                    double x = v.getElement(j);
                    v.setElement(j, v.getElement(j+1));
                    v.setElement(j+1, x);
                }


    }
}
