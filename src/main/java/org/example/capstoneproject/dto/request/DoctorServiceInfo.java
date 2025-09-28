package org.example.capstoneproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorServiceInfo {
    private Double price;
    private Integer durationMinutes;
}
