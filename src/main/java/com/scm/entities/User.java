package com.scm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity(name = "user")
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String userId;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(name = "user_emailAddress", unique = true, nullable = false)
    private String email;
    private String password;
    @Lob
    @Column(length = 10000)
    private String about;
    private String phoneNumber;
    @Lob
    @Column(length = 10000)
    private String profilePic;

    private Boolean enabled =false;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;
    private Providers provider = Providers.SELF;
    private String providerUserId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true )
    private List<Contact> contacts = new ArrayList<>();

}
