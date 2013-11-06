package Vectors;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 06.11.13
 * Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
public class ReadVector extends Thread {
    private Vector myVector;

    public ReadVector(Vector alterVector)
    {
        this.myVector=alterVector;
    }

    public void run()
    {
        for (int i=0; i<myVector.getSize(); i++)
        {
            System.out.println("Read: "+myVector.getElement(i)+" from position "+(i+1));
        }
    }
}
