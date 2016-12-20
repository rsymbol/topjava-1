package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UsersUtil {

    public static final List<User> USERS = Arrays.asList(
            new User("Ivanov", "ivanov@mail.ru", "111", Role.ROLE_ADMIN, Role.ROLE_USER),
            new User("Petrov", "petrov@mail.ru", "222", Role.ROLE_USER),
            new User("Sidorov", "sidorov@mail.ru", "333", Role.ROLE_USER)
    );

}