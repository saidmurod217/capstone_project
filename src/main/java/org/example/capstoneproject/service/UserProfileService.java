package org.example.capstoneproject.service;

import lombok.RequiredArgsConstructor;
import org.example.capstoneproject.dto.request.ProfileRequest;
import org.example.capstoneproject.entity.User;
import org.example.capstoneproject.entity.UserProfile;
import org.example.capstoneproject.repository.UserProfileRepository;
import org.example.capstoneproject.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> createOrUpdateProfile(ProfileRequest profileRequest, String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new RuntimeException("User not found: " + userName));

        UserProfile profile = userProfileRepository.findByUser(user)
                .orElse(new UserProfile()); // new if none exists

        profile.setUser(user);
        profile.setName(profileRequest.getName());
        profile.setSurname(profileRequest.getSurname());
        profile.setAge(profileRequest.getAge());
        userProfileRepository.save(profile);
        return ResponseEntity.ok(profile);
    }
    public List<UserProfile> findAll(){
        return userProfileRepository.findAll();
    }

}
