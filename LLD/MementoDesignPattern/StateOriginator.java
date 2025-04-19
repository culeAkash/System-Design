package LLD.MementoDesignPattern;

public class StateOriginator {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public StateMemento createMemento() {
        return new StateMemento(this.state);
    }

    public void restoreMemento(StateMemento stateMemento){
        this.state = stateMemento.state;
    }
}
