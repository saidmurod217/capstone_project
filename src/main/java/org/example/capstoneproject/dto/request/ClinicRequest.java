package org.example.capstoneproject.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicRequest {
    private String name;
    private String about;
    private String certification;
    private String address;
    private String phone;
    private String weblink;
    private Float rating;
    private String image;
}
