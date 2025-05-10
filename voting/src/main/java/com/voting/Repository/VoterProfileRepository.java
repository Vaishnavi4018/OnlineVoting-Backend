package com.voting.Repository;

import com.voting.Model.VoterProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoterProfileRepository extends JpaRepository<VoterProfile, Long> {
    Optional<VoterProfile> findByUsername(String username);
}