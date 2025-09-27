package org.example.capstoneproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorRequest {
    private String name;
    private Double experience;
    private String about;
    private Float rating;
}
