package com.example.userapi.controller;

import com.example.userapi.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class userController {

    private final Map<Long, User> userStore = new HashMap<>();
    private Long currentId = 1L;

    // Create User
    @PostMapping
    public User createUser(@RequestBody User user){
        user.setId(currentId++);
        userStore.put(user.getId(), user);
        return user;
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers(){
        return new ArrayList<>(userStore.values());
    }

    // Get User by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userStore.get(id);
    }

    // Update User
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        User existing = userStore.get(id);
        if(existing != null){
            existing.setName(updatedUser.getName());
            existing.setEmail(updatedUser.getEmail());
        }
        return existing;
    }

    // Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userStore.remove(id);
        return "User deleted";
    }

}
