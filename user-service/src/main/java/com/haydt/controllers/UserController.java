package com.haydt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

import com.haydt.entities.User;
import com.haydt.services.UserService;

import java.util.List;

@BaseController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("public/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("public/getAllUsers")
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }

    @GetMapping("public/user")
    public ResponseEntity<?> user() {

        return ResponseEntity.ok("You have role User");
    }

    @GetMapping("public/admin")
    public ResponseEntity<?> admin() {

        return ResponseEntity.ok("You have role Admin");
    }

    @GetMapping("public/user2")
    public ResponseEntity<?> user2() {

        return ResponseEntity.ok("Success");
    }

}
