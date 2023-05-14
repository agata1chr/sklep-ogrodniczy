package com.tyrytyry.security;
import com.tyrytyry.Register.UserRepository;
import com.tyrytyry.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public CustomUser registerUser(String username, String password) {
        CustomUser existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            throw new RuntimeException("Użytkownik o podanej nazwie już istnieje.");
        }

        CustomUser newUser = new CustomUser();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));

        return userRepository.save(newUser);
    }

    public CustomUser login(String username, String password) {
        CustomUser user = userRepository.findByUsername(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Niepoprawna nazwa użytkownika lub hasło.");
        }

        return user;
    }
}


