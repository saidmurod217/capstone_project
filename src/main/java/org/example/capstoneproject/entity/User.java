package org.example.capstoneproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.capstoneproject.enums.UserRole;


@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String username;


    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;


//    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
//    private UserProfile userProfile;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
//    private Clinic clinic;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
//    private Doctor doctor;
//
}