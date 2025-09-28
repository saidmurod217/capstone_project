package org.example.capstoneproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.capstoneproject.entity.MedicalService;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorServiceResponse {
    private Double price;
    private Integer durationMinutes;

    private DoctorSummary doctorSummary;
    private MedicalService medicalService;
}
