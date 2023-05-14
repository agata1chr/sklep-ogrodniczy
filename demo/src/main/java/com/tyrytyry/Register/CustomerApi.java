package com.tyrytyry.Register;

import com.tyrytyry.model.SingUpCredentials;
import com.tyrytyry.model.UserSettings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/user")
class CustomerApi {

    private final UserService userService;

    CustomerApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public ResponseEntity<UserSettings> getUserData(Principal principal) {
        return new ResponseEntity<>(userService.getUserSettings(principal.getName()), HttpStatus.OK);
    }

    @PostMapping("/singUp")
    public ResponseEntity<String> singUpUser(@RequestBody SingUpCredentials singUpCredentials) {
        try {
            return new ResponseEntity<>(userService.createNewUser(singUpCredentials), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/edit")
    public ResponseEntity<UserSettings> updateUserData(@RequestBody UserSettings userSettings, Principal principal) {
        return new ResponseEntity<>(userService.updateUserData(userSettings, principal.getName()), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    @Transactional
    public ResponseEntity<String> deleteUser(Principal principal) {
        userService.deleteUser(principal.getName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
