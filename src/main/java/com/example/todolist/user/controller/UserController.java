package com.example.todolist.user.controller;

import com.example.todolist.user.model.User;
import com.example.todolist.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get-id/{username}")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<Integer> getIdByUsername(@PathVariable String username){
        return new ResponseEntity<>(userService.getIdByUsername(username),HttpStatus.OK);
    }

    @PostMapping
    public String post(){
        return "post Map";
    }

    @PutMapping
    public String put(){
        return "put Map";
    }

    @DeleteMapping
    public String delete(){
        return "delete Map";
    }

    @GetMapping("/get-user/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
