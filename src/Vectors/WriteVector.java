package Vectors;


import java.util.Random;

public class WriteVector extends Thread {
    private Vector myVector;

    public WriteVector(Vector alterVector)
    {
        this.myVector=alterVector;
    }

    public void run()
    {
        Random rand = new Random();
        for (int i=0; i<myVector.getSize(); i++)
        {
            double value = rand.nextDouble()*10;
            myVector.setElement(i, value);
            System.out.println("Write: "+value+" to position "+(i+1));
        }
    }
}
