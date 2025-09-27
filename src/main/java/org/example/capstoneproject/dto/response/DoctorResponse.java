package org.example.capstoneproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponse {
    private Integer id;
    private String name;
    private Double experience;
    private String about;
    private Float rating;
    List<ClinicSummary> clinics;
}
