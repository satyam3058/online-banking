package com.onlinebanking.springrest.controller;

import com.onlinebanking.springrest.model.User;
import com.onlinebanking.springrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1.0/bank")
public class MyController {
    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String home(){
    	return "Hello!";
    }
    
    @GetMapping("/alldetails")
    public ResponseEntity<List<User>> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/newaccount")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user){
        return userService.loginUser(user);
    }

    @GetMapping("/balance/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId){
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long userId){
        return userService.updateUser(user, userId);
    }
    
    @PutMapping("/delete/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable long userId){
        return userService.deleteUser(userId);
    }
}
