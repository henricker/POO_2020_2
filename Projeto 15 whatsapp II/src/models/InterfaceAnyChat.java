package models;

import exceptions.ExceptionController;

public interface InterfaceAnyChat {
    public void addUser(User user) throws ExceptionController;
    public void remUser(User user) throws ExceptionController;
}