package Exceptioner;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 04.11.13
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
public class VectorIndexOutOfBoundsException extends RuntimeException {
    private String message;

    public VectorIndexOutOfBoundsException()
    {
        message=null;
    }

    public VectorIndexOutOfBoundsException(String message)
    {
        this.message=message;
    }

    public String toString()
    {
        return "VectorIndexOutOfBoundsException: "+message;
    }
}
