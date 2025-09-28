package org.example.capstoneproject.repository;

import org.example.capstoneproject.entity.User;
import org.example.capstoneproject.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {

    Optional<UserProfile> findByUser(User user);
}
