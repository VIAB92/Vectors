package Adapters;
import java.util.Vector;
public class JVectorAdapter implements Vectors.Vector{
    Vector<Double> vect;

    public JVectorAdapter(Vector<Double> vector)
    {
        this.vect=vector;
    }

    @Override
    public double getElement(int index) {
        return this.vect.get(index);
    }

    @Override
    public void setElement(int index, double value) {
        this.vect.set(index, value);
    }

    @Override
    public int getSize() {
        return this.vect.size();
    }

    @Override
    public void printVector() {
       for(Double d:vect)
           System.out.print(d);
        System.out.println();
    }

    @Override
    public boolean compareWithVector(Vectors.Vector anotherVector) {
        if(this.vect.size()!=anotherVector.getSize())
            return false;
        for(int i=0; i<this.getSize(); i++)
        {
            if (this.getElement(i)!=anotherVector.getElement(i))
                return false;
        }
        return true;
    }

    @Override
    public void sumWithVector(Vectors.Vector anotherVector) {
        if (this.vect.size() != anotherVector.getSize())
            System.out.println("Длины векторов не совпадают!");
        else
        {
            for (int i=0; i<this.getSize(); i++)
            {
                this.setElement(i, this.getElement(i)+anotherVector.getElement(i));
            }
        }
    }

    @Override
    public void multiplyOn(double value) {
        for (int i=0; i<this.getSize(); i++)
        {
            this.setElement(i, this.getElement(i)*value);
        }
    }

    @Override
    public void fillFromArray(double[] arr) {
       vect = null;
        vect = new Vector<Double>();
        for(double d:arr)
            vect.add(d);
    }

    @Override
    public void fillFromVector(Vectors.Vector vector) {
        vect = null;
        vect = new Vector<Double>();
        for(int i=0;i<vector.getSize(); i++)
        {
            vect.add(vector.getElement(i));
        }
    }
}
