package Client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static List<String> stringVectors = new ArrayList<String>();
    private static Socket connection;
    private static int port = 1100;
    private static String address = "127.0.0.1";
    private static ObjectOutputStream outputObject;
    private static ObjectInputStream inputObject;

    public static void main(String[] args) throws IOException {
        gimmeVectors();
        sendData();
        System.out.println(stringVectors.get(0)+ "\n" + stringVectors.get(1));


    }

    public static void gimmeVectors()
    {
        try
        {
            BufferedReader dataFile = new BufferedReader(new FileReader("vector.txt"));
            while(true)
            {
                String str = dataFile.readLine();
                if (str==null) break;
                stringVectors.add(str);
            }
            dataFile.close();
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch(IOException ex2)
        {
            ex2.printStackTrace();
        }
    }

    private static void writeResult(String result)
    {
        try
        {
            BufferedWriter resultFile = new BufferedWriter(new FileWriter("result.txt"));
            resultFile.write(result);
            resultFile.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }


    }

    private static void sendData()
    {
        try
        {
            connection = new Socket(address, port);
            outputObject = new ObjectOutputStream(connection.getOutputStream());
            inputObject = new ObjectInputStream(connection.getInputStream());

            String st = "";
            for (int i=0; i<stringVectors.size(); i+=2)
            {
                outputObject.writeObject(stringVectors.get(i));
                outputObject.writeObject(stringVectors.get(i+1));

                st+=(String) inputObject.readObject();
                st+="\n";
                System.out.println("From server: "+st);
            }
            writeResult(st);
            connection.close();
            System.out.println("You are connected");
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }

}
