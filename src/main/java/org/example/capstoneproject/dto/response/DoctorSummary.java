package org.example.capstoneproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorSummary {
    private Integer id;
    private String name;
    private Double experience;
    private String about;
    private Float rating;
}
