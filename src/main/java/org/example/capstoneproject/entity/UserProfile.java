package org.example.capstoneproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.capstoneproject.entity.User;

@Entity
@Table(name = "user_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private Integer age;


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}