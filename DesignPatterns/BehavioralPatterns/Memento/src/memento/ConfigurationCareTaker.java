package memento;

import java.util.Stack;

public class ConfigurationCareTaker {

	Stack<ConfigurationMemento> history;

	public ConfigurationCareTaker() {
		this.history = new Stack<>();
	}

	public void addMemento(ConfigurationMemento memento) {
		this.history.add(memento);
	}

	public ConfigurationMemento undo() {
		if (history.size() != 0) {
			return history.pop();
		}
		return null;
	}

}
