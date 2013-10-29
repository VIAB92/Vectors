package Vectors;


import ObservRealization.Observable;
import ObservRealization.Observer;

import java.util.ArrayList;

public abstract class ObservableVector implements Observable {
    protected ArrayList observers = new ArrayList();
    protected int element = 0;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int id = observers.indexOf(o);
        if (id>=0) observers.remove(id);
    }

    @Override
    public void notifyObserver(String action) {
        for (int i=0; i<observers.size(); i++)
        {
            Observer obs = (Observer)observers.get(i);
            if (action.toLowerCase().equals("element")) obs.update_element(element);
            if (action.toLowerCase().equals("vector")) obs.update_vector();
        }
    }
}
