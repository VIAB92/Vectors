package Exceptioner;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 04.11.13
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
public class IncompatibleVectorSizesException extends Exception {
    private String message;

    public IncompatibleVectorSizesException()
    {
        this.message=null;
    }

    public IncompatibleVectorSizesException(String msg)
    {
        this.message=msg;
    }

    public String toString()
    {
        return "Vector size are incompatible: "+message;
    }
}
