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
            new User(1, "Ivanov", "ivanov@mail.ru", "111", MealsUtil.DEFAULT_CALORIES_PER_DAY, true, EnumSet.of(Role.ROLE_ADMIN, Role.ROLE_USER)),
            new User(2, "Petrov", "petrov@mail.ru", "222", MealsUtil.DEFAULT_CALORIES_PER_DAY, true, EnumSet.of(Role.ROLE_USER)),
            new User(3, "Sidorov", "sidorov@mail.ru", "333", MealsUtil.DEFAULT_CALORIES_PER_DAY, true, EnumSet.of(Role.ROLE_USER))
    );

}