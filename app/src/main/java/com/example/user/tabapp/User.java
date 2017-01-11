package com.example.user.tabapp;

/**
 * Created by user on 26/11/2016.
 *
 * This is the data-transfer-object (DTO) for the User entity
 *
 */

public class User {

    private String username;
    private String pin;
    private boolean isAdmin=false;

    public User() {
        // default constructor
    }

    public User(String username, String pin, boolean isAdmin) throws UserException {
        this.setUsername(username);
        this.setPin(pin);
        this.setAdmin(isAdmin);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws UserException {
        if(username.isEmpty() || username.length() > 50)
            throw new UserException("Invalid Username entered");

        this.username = username;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws UserException {
        if (pin.isEmpty() || pin.length() > 8)
            throw new UserException("Invalid PIN entered");

        this.pin = pin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    public String toString() {
        return this.username + ";" + this.pin + ";";
    }
}
