package LLD.MementoDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class StateCaretaker {
    List<StateMemento> history = new ArrayList<>();

    public void addMemento(StateMemento stateMemento) {
        history.add(stateMemento);
    }


    public StateMemento undo(){
        if(!history.isEmpty()){
            return history.remove(history.size()-1);
        }
        return null;
    }
}
