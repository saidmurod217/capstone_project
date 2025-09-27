package org.example.capstoneproject.repository;

import org.example.capstoneproject.entity.User;
import org.example.capstoneproject.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {

    Optional<UserProfile> findByUser(User user);
}
