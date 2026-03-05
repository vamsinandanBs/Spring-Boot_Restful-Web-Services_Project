package com.vamsi.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users =new  ArrayList<>();

    static {
        users.add(new User(1,"Vamsi", LocalDate.now().minusYears(26)));
        users.add(new User(2,"Kiran", LocalDate.now().minusYears(46)));
        users.add(new User(3,"Suresh", LocalDate.now().minusYears(55)));
        users.add(new User(4,"Lakshmi", LocalDate.now().minusYears(45)));
    }

    public  List<User> findAll() {
        return users;
    }

//    public User findOne(int id) {
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        return users.stream().filter(predicate).findFirst().get();
//    }

}
