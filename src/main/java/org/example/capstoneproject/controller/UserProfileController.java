package org.example.capstoneproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.capstoneproject.dto.request.ProfileRequest;
import org.example.capstoneproject.entity.UserProfile;
import org.example.capstoneproject.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/profile")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping
    ResponseEntity<?> createProfile(@RequestBody ProfileRequest profileRequest){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return userProfileService.createOrUpdateProfile(profileRequest, username);
    }
    @GetMapping
    public List<UserProfile> getAllUserProfiles(){
        return userProfileService.findAll();
    }
}

