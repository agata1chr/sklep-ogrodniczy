package com.tyrytyry.Register;

import com.tyrytyry.model.CustomUser;
import com.tyrytyry.model.SingUpCredentials;
import com.tyrytyry.model.UserSettings;
import com.tyrytyry.Register.RoleRepository;
import com.tyrytyry.Register.SettingsRepository;
import com.tyrytyry.Register.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
class UserService {


private final UserRepository userRepository;
private final SettingsRepository settingsRepository;
private final RoleRepository roleRepository;

        UserService(UserRepository userRepository, SettingsRepository settingsRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.settingsRepository = settingsRepository;
        this.roleRepository = roleRepository;
        }

        String createNewUser(SingUpCredentials singUpCredentials) {
        UserSettings userSettings = new UserSettings(singUpCredentials.getEmail(), singUpCredentials.getPhoneNumber());
        userSettings = settingsRepository.save(userSettings);
        CustomUser customUser = new CustomUser(
        singUpCredentials.getUsername(),
        "{bcrypt}" + new BCryptPasswordEncoder().encode(singUpCredentials.getPassword()),
        List.of(roleRepository.getRoleByName("USER").get()),
        userSettings);

        return userRepository.save(customUser).getUsername();
        }

        UserSettings getUserSettings(String name) {
        return userRepository.getMyUserByUsername(
        name
        ).orElseThrow(NoSuchElementException::new)
        .getUserSettings();
        }

        UserSettings updateUserData(UserSettings userSettings, String name) {
        userSettings.setId(getUserSettings(name).getId());
        return settingsRepository.save(userSettings);
        }

        void deleteUser(String name) {
        userRepository.deleteByUsername(name);
        }
        }
