package com.tyrytyry.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.UUID;

@Entity
@ToString
@Getter
@Setter
public class UserSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition="UUID")
    private UUID id;
    private int phoneNumber;
    private String email;

    public UserSettings(String email, int phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public UserSettings() {
    }
}
