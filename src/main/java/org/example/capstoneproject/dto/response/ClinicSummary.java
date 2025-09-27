package org.example.capstoneproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicSummary {
    private String name;
    private String address;
    private String phone;
    private String weblink;
}
