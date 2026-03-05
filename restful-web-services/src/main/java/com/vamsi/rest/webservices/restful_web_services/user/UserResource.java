package com.vamsi.rest.webservices.restful_web_services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service=service;
    }

    @GetMapping("/users")
    public List<User> RetriveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User RetriveUser(@PathVariable int id){
         //service.findOne(id);
        User user = service.findOne(id);

        if(user==null)
            throw new UserNotFoundException("id:"+id);

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser= service.insertUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
