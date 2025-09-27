package org.example.capstoneproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "clinics")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String about;
    private String certification;
    private String address;
    private String phone;
    private String weblink;
    private Float rating;
    private String image;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "clinic_doctors",
    joinColumns = @JoinColumn(name = "clinic_id"),
    inverseJoinColumns = @JoinColumn(name = "doctor_id"))
    Set<Doctor> doctors = new HashSet<>();

    public void addDoctor(Doctor doctor){
        doctor.getClinic().add(this);
        doctors.add(doctor);
    }

}