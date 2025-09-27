package org.example.capstoneproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicResponse {
    private Integer id;
    private String name;
    private String about;
    private String certification;
    private String address;
    private String phone;
    private String weblink;
    private Float rating;
    private String image;
    List<DoctorSummary> doctors;
}
