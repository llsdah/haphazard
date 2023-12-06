package org.example.model;

import java.util.Objects;

public class User {


    private final String id;
    private final String pass;

    public User(String id, String pass){
        this.id = id;
        this.pass = pass;

    }

    public boolean equalUser(User user){
        return this.equals(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(pass, user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pass);
    }
}
