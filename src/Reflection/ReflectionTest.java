package Reflection;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args)
    {
        if (args.length!=4)
        {
           try
           {
               Class clazz = Class.forName(args[0]);
               Double value1 = Double.valueOf(args[2]);
               Double value2 = Double.valueOf(args[3]);

               Method method = clazz.getMethod(args[1], new Class[]{Double.TYPE, Double.TYPE});
               Object res = method.invoke(null, new Object[]{value1, value2});
               System.out.println(res.toString());
           }
           catch (ClassNotFoundException e) {
               System.out.println("Class not found");
           } catch (NoSuchMethodException e) {
               System.out.println("Method not found");
               e.printStackTrace();
           } catch (IllegalAccessException e) {
               System.out.println("Method is not accessable");
           } catch (InvocationTargetException e) {
               System.out.println("An exception occured when method was invoked");
           }
        }
        else
        {
            System.out.println("Извините, но вы не ввели требуемое количество параметров");
        }
    }
}
