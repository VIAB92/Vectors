package Vectors;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 06.11.13
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class VectorWriter implements Runnable {

    SyncHelper syncHelper;

    public VectorWriter(SyncHelper helper)
    {
        this.syncHelper=helper;
        new Thread(this, "Writer").start();
    }

    @Override
    public void run() {
        Random rand = new Random();

        int i=0;
        while(i<syncHelper.size)
        {
            syncHelper.write(i,rand.nextDouble()*10);
            i++;
        }
    }
}
