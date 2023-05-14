package com.tyrytyry;

import com.tyrytyry.model.CustomUser;
import com.tyrytyry.model.Role;
import com.tyrytyry.model.UserSettings;
import com.tyrytyry.Register.RoleRepository;
import com.tyrytyry.Register.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.List;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println("Init start");

		Role roleUser = new Role("USER");
		Role roleAdmin = new Role("ADMIN");
		Role undefined = new Role("UNDEFINED");

		UserSettings adminSettings = new UserSettings("admin@gmail.com",234324);

		roleRepository.save(roleAdmin);
		roleRepository.save(roleUser);
		roleRepository.save(undefined);

		CustomUser myUserAdmin = new CustomUser("admin", "{bcrypt}" + new BCryptPasswordEncoder().encode("admin"),
				List.of(roleRepository.getRoleByName("ADMIN").orElse(undefined)), adminSettings

		);

		CustomUser userMyUser = new CustomUser("user", "{bcrypt}" + new BCryptPasswordEncoder().encode("user"),
				List.of(roleRepository.getRoleByName("USER").orElse(undefined)), true);

		userRepository.save(myUserAdmin);
		userRepository.save(userMyUser);
	}
}


