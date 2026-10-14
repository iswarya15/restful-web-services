package com.in28minutes.rest.webservices.restful_web_services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path="/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUserById(@PathVariable Integer id) {
        User user = userDaoService.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id " + id);
        return user;
    }

    @PostMapping(path="/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = this.userDaoService.save(user);

        // users/4 => /users/{id}, user.getId()
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/users/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userDaoService.deleteById(id);
    }
}
