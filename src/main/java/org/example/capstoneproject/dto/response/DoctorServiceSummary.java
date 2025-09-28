package org.example.capstoneproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.capstoneproject.entity.MedicalService;

@Data
@AllArgsConstructor@NoArgsConstructor
public class DoctorServiceSummary {
    private Double price;
    private Integer durationMinutes;
    private MedicalService medicalService;
}
