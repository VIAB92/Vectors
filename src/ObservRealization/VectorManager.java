package ObservRealization;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 29.10.13
 * Time: 15:24
 * To change this template use File | Settings | File Templates.
 */
public class VectorManager implements Observer {
    @Override
    public void update_element(int index) {
        System.out.println("Элемент "+index+" в векторе был изменен");
    }

    @Override
    public void update_vector() {
        System.out.println("Вектор был изменен");
    }
}
