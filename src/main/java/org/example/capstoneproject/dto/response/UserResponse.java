package org.example.capstoneproject.dto.response;


import lombok.Data;
import org.example.capstoneproject.enums.UserRole;

@Data
public class UserResponse {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private UserRole role;
}