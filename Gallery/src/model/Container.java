package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Container {
	protected static final ObservableList<User> users = FXCollections.observableArrayList();
	protected static final AuthContainer auths = new AuthContainer();
	abstract public ObservableList<User> getUsers();
}
