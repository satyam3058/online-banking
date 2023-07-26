package com.onlinebanking.springrest.service;


import com.onlinebanking.springrest.model.User;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface UserService {

    public ResponseEntity<List<User>> getAllUsers();

    public ResponseEntity<User> addUser(User user);

    public ResponseEntity<User> loginUser(User user);

    public ResponseEntity<User> getUserById(long userId);

    public ResponseEntity<User> updateUser(User user, long userId);

	public ResponseEntity<User> deleteUser(long userId);
}