package com.voting.Service;

import com.voting.Model.VoterProfile;
import com.voting.Repository.VoterProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoterProfileService {
    @Autowired
    private VoterProfileRepository voterProfileRepository;

    // Method to fetch voter profile by ID (GET operation)
    public VoterProfile getVoterProfile(Long voterId) {
        return voterProfileRepository.findById(voterId)
                .orElseThrow(() -> new RuntimeException("Voter profile not found with id: " + voterId));
    }

    // Method to update voter profile (POST operation for "Edit Profile")
    public VoterProfile updateVoterProfile(Long voterId, VoterProfile updatedProfile) {
        VoterProfile existingProfile = voterProfileRepository.findById(voterId)
                .orElseThrow(() -> new RuntimeException("Voter profile not found with id: " + voterId));

        // Update fields
        existingProfile.setUsername(updatedProfile.getUsername());
        existingProfile.setEmail(updatedProfile.getEmail());
        existingProfile.setAadharCardNumber(updatedProfile.getAadharCardNumber());
        existingProfile.setPassword(updatedProfile.getPassword());

        // Check for duplicate username (excluding the current voter)
        Optional<VoterProfile> duplicateProfile = voterProfileRepository.findByUsername(updatedProfile.getUsername());
        if (duplicateProfile.isPresent() && !duplicateProfile.get().getId().equals(voterId)) {
            throw new RuntimeException("Username already exists");
        }

        return voterProfileRepository.save(existingProfile);
    }

    // Method to create a voter profile (optional, for initial setup)
    public VoterProfile createVoterProfile(VoterProfile voterProfile) {
        Optional<VoterProfile> existingProfile = voterProfileRepository.findByUsername(voterProfile.getUsername());
        if (existingProfile.isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        return voterProfileRepository.save(voterProfile);
    }
}