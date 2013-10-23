package Factories;
import Vectors.Vector;
/**
 * Created with IntelliJ IDEA.
 * User: Victor Rotar
 * Date: 23.10.13
 * Time: 20:33
 * To change this template use File | Settings | File Templates.
 */
public interface VectorFactory {
    Vector createVector();
    Vector createVector(int length);
}
