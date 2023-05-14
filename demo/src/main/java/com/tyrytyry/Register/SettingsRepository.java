package com.tyrytyry.Register;

import com.tyrytyry.model.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SettingsRepository extends JpaRepository<UserSettings, UUID> {
}
