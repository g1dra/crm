package com.g1dra.crm.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "App_user")
public class User {

    public User() {
    }

    public User(String firstName, String lastName,
                String email, String password,
                boolean enabled, boolean tokenExpired,
                LocalDateTime createdAt, LocalDateTime updatedAt)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.tokenExpired = tokenExpired;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private boolean enabled;

    @Column(nullable = true)
    private boolean tokenExpired;

    @Column(nullable = true)
    private String imagePath;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
