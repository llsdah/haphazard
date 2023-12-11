package org.example.repository;

import org.example.model.User;

import java.util.*;

public class UserRepository {

    private static Map<String, User> user = new HashMap<>();

    public static void save(User users){
        user.put(users.getUserId(),users);
    }

    public static Collection<User> findAll() {
        return user.values();
    }
}
