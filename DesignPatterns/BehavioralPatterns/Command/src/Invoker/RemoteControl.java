package Invoker;

import java.util.Stack;

import command.ICommand;

public class RemoteControl {

	ICommand command;

	Stack<ICommand> undoStack;

	public RemoteControl() {
		this.undoStack = new Stack<>();
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
		undoStack.push(command);
	}

	public void undo() {
		while (undoStack.size() != 0) {
			undoStack.pop().undo();
		}
	}

}
