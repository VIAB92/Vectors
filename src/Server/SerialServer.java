package Server;

import Exceptioner.IncompatibleVectorSizesException;
import Vectors.LinkedListVector;
import Vectors.Vector;
import Vectors.Vectors;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SerialServer {
    private static Socket in;
    private static ServerSocket serverSocket;
    private static int port = 1100;
    private static ObjectOutputStream outputObject;
    private static ObjectInputStream inputObject;

    public static void main(String[] args)
    {
        getData();
    }

    public static void getData()
    {
        try
        {
            serverSocket = new ServerSocket(port);
            in = serverSocket.accept();

            outputObject = new ObjectOutputStream(in.getOutputStream());
            inputObject = new ObjectInputStream(in.getInputStream());
            String st;
            Vector v1 = null;
            Vector v2 = null;
            Vector result = null;
            boolean flag = true;
            while(true)
            {
                st = (String) inputObject.readObject();

                 String[] numbers = st.split(" ");
                 double[] vals = new double[numbers.length];
                for(int i=0; i<numbers.length; i++)
                {
                    String val = numbers[i];
                    double value = Double.parseDouble(val);
                    vals[i]=value;
                }

                if (flag)
                {
                    v1 = new LinkedListVector(vals);
                    flag = false;
                }
                else
                {
                    v2 = new LinkedListVector(vals);
                    result = Vectors.sumVectors(v1, v2);
                    for (int i=0; i<result.getSize(); i++)
                    {
                        System.out.println("result element "+i+" = "+result.getElement(i));
                    }
                    outputObject.writeObject(result.toString());
                    flag=true;
                }


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IncompatibleVectorSizesException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            try {
                serverSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            getData();
        }


    }
}
