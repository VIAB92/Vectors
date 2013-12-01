package Server;


import Exceptioner.IncompatibleVectorSizesException;
import Vectors.LinkedListVector;
import Vectors.Vector;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ParallelServer {
    private Socket in;
    private ServerSocket serverSocket;
    private int port = 1100;
    public ParallelServer(){
        this.getData();
    }

    private void getData() {
        try {
            serverSocket = new ServerSocket(port);

            while(true){
                in = serverSocket.accept();
                Thread thread = new ClientsConnection();
                thread.start();
            }


        } catch (BindException e) {
            System.out.println("Program is already running.");
            System.exit(0);
        } catch (SocketException e) {
            System.out.println("Client disconnect.");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
    class ClientsConnection extends Thread {
        private ObjectOutputStream outputObject;
        private ObjectInputStream inputObject;

        public void run() {
            try {
                this.outputObject = new ObjectOutputStream(in.getOutputStream());
                this.inputObject = new ObjectInputStream(in.getInputStream());
                String st;
                Vector v1 = null;
                Vector v2 = null;
                Vector sum = null;
                boolean flag = true;
                while (true) {
                    st = (String) this.inputObject.readObject();
                    String[] numbers = st.split(" ");
                    double[] vals = new double[numbers.length];
                    for(int i=0; i<numbers.length; i++)
                    {
                        String val = numbers[i];
                        double value = Double.parseDouble(val);
                        vals[i]=value;
                    }

                    if (flag) {
                        v1 = new LinkedListVector(vals);
                        flag = false;
                    } else {
                        v2 = new LinkedListVector(vals);
                        sum = Vectors.Vectors.sumVectors(v1, v2);

                        for (int i = 0; i < sum.getSize(); i++) {
                            System.out.println("sum.getElement(i) = " + sum.getElement(i));
                        }
                        this.outputObject.writeObject(sum.toString());
                        flag = true;
                    }
                }
            } catch (SocketException e) {
                System.out.println("Client disconnect.");
            } catch (IOException e) {
                 System.out.println("Клиент отключился");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IncompatibleVectorSizesException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}


