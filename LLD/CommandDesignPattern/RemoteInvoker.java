package LLD.CommandDesignPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LLD.CommandDesignPattern.iComand.ButtonICommand;

public class RemoteInvoker {
    List<ButtonICommand> buttons;
    Stack<ButtonICommand> undoStack = new Stack<>();

    public RemoteInvoker() {
        buttons = new ArrayList<>();
    }

    public void add(ButtonICommand button) {
        buttons.add(button);
    }

    public void pressButton(int index){
        if(index >= 0 && index < buttons.size()){
            ButtonICommand button = buttons.get(index);
            button.execute();
            undoStack.push(button);
        }
    }

    public void undo(){
        if(!undoStack.isEmpty()){
            ButtonICommand button = undoStack.pop();
            button.undo();
        }
    }
}
