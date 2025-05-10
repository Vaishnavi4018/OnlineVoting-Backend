package com.voting.Service;

import com.voting.Model.CandidateRegistration;
import com.voting.Repository.CandidateRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateRegistrationService {
    @Autowired
    private CandidateRegistrationRepository candidateRegistrationRepository;

    // Method to add a new candidate (POST operation for "ADD CANDIDATE")
    public CandidateRegistration addCandidate(CandidateRegistration candidate) {
        // Basic validation (can be enhanced)
        if (candidate.getElectionName() == null || candidate.getElectionName().trim().isEmpty() ||
            candidate.getCandidateName() == null || candidate.getCandidateName().trim().isEmpty() ||
            candidate.getCandidateId() == null || candidate.getCandidateId().trim().isEmpty()) {
            throw new RuntimeException("Election Name, Candidate Name, and Candidate ID are required");
        }
        return candidateRegistrationRepository.save(candidate);
    }
}