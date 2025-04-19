package LLD.MementoDesignPattern;

public class Main {
    public static void main(String[] args) {
        State state1 = new State(4,5);
        StateOriginator stateOriginator = new StateOriginator();
        stateOriginator.setState(state1);


        StateMemento stateMemento = stateOriginator.createMemento();


        StateCaretaker stateCaretaker = new StateCaretaker();
        stateCaretaker.addMemento(stateMemento);


        State state2 = new State(6,7);
        stateOriginator.setState(state2);

        stateMemento = stateOriginator.createMemento();
        stateCaretaker.addMemento(stateMemento);

        State state3 = new State(8,7);
        stateOriginator.setState(state3);

        stateOriginator.restoreMemento(stateCaretaker.undo());

        System.out.println(stateOriginator.getState());
    }
}