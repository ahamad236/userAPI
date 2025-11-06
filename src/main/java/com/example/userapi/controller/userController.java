package com.example.userapi.controller;

import com.example.userapi.model.User;
import com.example.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private UserRepository repo;

    //private final Map<Long, User> userStore = new HashMap<>();
    //private Long currentId = 1L;

    // Create User
    @PostMapping
    public User createUser(@RequestBody User user) {
//        user.setId(currentId++);
//        userStore.put(user.getId(), user);
//        return user;

        return repo.save(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        //return new ArrayList<>(userStore.values());

        return repo.findAll();
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable @RequestParam Long id) {
//        return userStore.get(id);

//        Optional<User> user = userRepository.findById(id);
//        return user.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());

        Optional<User> user = repo.findById(id);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//        User existing = userStore.get(id);
//        if (existing != null) {
//            existing.setName(updatedUser.getName());
//            existing.setEmail(updatedUser.getEmail());
//        }
//        return existing;


        return repo.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    repo.save(user);
                    return ResponseEntity.ok(user);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        return repo.findById(id)
                .map(user -> {
                    repo.delete(user);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
