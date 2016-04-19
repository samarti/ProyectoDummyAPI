package model;

/**
 * Created by Santiago Martí Olbrich (samarti@uc.cl) on 4/18/16.
 * Resit SpA.
 * All rights reserved
 */
public class User {

    int id;
    String password;

    public User(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
