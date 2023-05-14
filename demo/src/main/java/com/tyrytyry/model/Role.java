package com.tyrytyry.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;


import java.util.UUID;

@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Getter
public class Role  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition="UUID")
    private UUID id;
    @Column(unique = true)
    private String name;

    public Role(String name) {
        this.name = name;
    }


    public String getAuthority() {
        return this.name;
    }
}
