package org.example.capstoneproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSummary {
    private Integer id;
    private String name;
    private Double experience;
    private String about;
    private Float rating;
}
