package LLD.MementoDesignPattern;

public class StateMemento {
    State state;

    public StateMemento(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
