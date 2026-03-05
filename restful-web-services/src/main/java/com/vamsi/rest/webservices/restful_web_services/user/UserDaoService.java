package com.vamsi.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users =new  ArrayList<>();

    private static int usersCount=0;

    static {
        users.add(new User(++usersCount,"Vamsi", LocalDate.now().minusYears(26)));
        users.add(new User(++usersCount,"Kiran", LocalDate.now().minusYears(46)));
        users.add(new User(++usersCount,"Suresh", LocalDate.now().minusYears(55)));
        users.add(new User(++usersCount,"Lakshmi", LocalDate.now().minusYears(45)));
    }

    public  List<User> findAll() {
        return users;
    }

    public  User  insertUser(User user) {
        user.setId((++usersCount));
        users.add(user);

        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
       //return users.stream().filter(predicate).findFirst().get();
        // if not found it gives exception instead adding or else with default value
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

}
