package org.example.capstoneproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctor_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private MedicalService service;

    @Column(nullable = false)
    private Double price;

    private Integer durationMinutes;
}
