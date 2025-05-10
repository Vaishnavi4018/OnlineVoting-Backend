package com.voting.Service;

import com.voting.Model.VoterLogin;
import com.voting.Repository.VoterLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoterLoginService {
    @Autowired
    private VoterLoginRepository voterLoginRepository;

    public VoterLogin registerVoter(VoterLogin voter) {
        Optional<VoterLogin> existingVoter = voterLoginRepository.findByUsername(voter.getUsername());
        if (existingVoter.isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        return voterLoginRepository.save(voter);
    }

    public VoterLogin loginVoter(String username, String password) {
        Optional<VoterLogin> voter = voterLoginRepository.findByUsername(username);
        if (voter.isPresent() && voter.get().getPassword().equals(password)) {
            return voter.get();
        }
        throw new RuntimeException("Invalid username or password");
    }
}