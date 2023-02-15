package com.example.sercuritytodo.controller;

import com.example.sercuritytodo.model.MyUser;
import com.example.sercuritytodo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @GetMapping
    public ResponseEntity getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body("USer");
    }
@PostMapping("/register")
    public ResponseEntity register(@RequestBody MyUser myUser){
        authService.register(myUser);
       return ResponseEntity.status(200).body("Done");
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(HttpStatus.OK).body("Weelcom back");
    }
    @PostMapping("/admin")
    public ResponseEntity admin(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome back ADMIN");
    }

    @PostMapping("/user")
    public ResponseEntity user(){
        return ResponseEntity.status(HttpStatus.OK).body("Welcome back user");
    }

}
