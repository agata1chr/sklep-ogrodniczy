//package com.tyrytyry.security;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/register")
//public class AuthController {
//    private final AuthService authService;
//
//    @Autowired
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest registerRequest) {
//        try {
//            authService.registerUser(registerRequest.getUsername(), registerRequest.getPassword());
//            return new ResponseEntity<>("Konto zostało pomyślnie utworzone.", HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
//        try {
//            authService.login(loginRequest.getUsername(), loginRequest.getPassword());
//            return new ResponseEntity<>("Pomyślnie zalogowano.", HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
//        }
//    }
//}
//
