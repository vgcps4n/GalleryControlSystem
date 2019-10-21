package model;

import data.DataBase;
import data.DataBaseSelector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Container {
	protected static final ObservableList<User> users = FXCollections.observableArrayList();
	protected static final AuthContainer auths = new AuthContainer();
//	protected final DataBase db = DataBaseSelector.SelectDB();
	abstract public ObservableList<User> getUsers();
}
