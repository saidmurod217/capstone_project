package org.example.capstoneproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clinic_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClinicService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clinic_id", nullable = false)
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private MedicalService service;

    @Column(nullable = false)
    private Double price;

    private Integer durationMinutes; // optional override
}
