package Vectors;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 06.11.13
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */
public class SyncHelper {
    Vector vect;
    boolean valueSet=false;
    int n;
    public int size;
    public SyncHelper(Vector vect)
    {
        this.vect=vect;
        this.size=vect.getSize();
    }

    synchronized int read()
    {
        while(!valueSet)
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("InterruptedException перехвачен");
            }
        System.out.println("Read: " + vect.getElement(n)+" from position "+(n+1));
        valueSet=false;
        notify();
        return n;

    }

    synchronized void write(int n, double value)
    {
        while(valueSet)
            try
            {
                wait();
            }
            catch(InterruptedException ex)
            {
                System.out.println("InterruptedException перехвачен");
            }
        this.n=n;
        valueSet=true;
        this.vect.setElement(n,value);
        System.out.println("Write: "+value+"to position "+(n+1));
        notify();

    }


}
