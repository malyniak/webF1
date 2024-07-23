package com.app.webf1.user;

import com.app.webf1.annotation.ValidPhoneNumber;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 128)
    private String email;
    @Column(nullable = false, unique = true)
    @ValidPhoneNumber
    private String phoneNumber;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Role role;
}
