package com.voting.Service;



import com.voting.Model.VoterRegistrationModel;
import com.voting.Repository.VoterRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoterRegistrationService {

    @Autowired
    private VoterRegistrationRepository voterRegistrationRepository;

    public VoterRegistrationModel registerVoter(VoterRegistrationModel voter) {
        return voterRegistrationRepository.save(voter);
    }

    public Optional<VoterRegistrationModel> findByEmail(String email) {
        return voterRegistrationRepository.findByEmail(email);
    }

    public boolean verifyEmail(String email) {
        Optional<VoterRegistrationModel> voterOpt = voterRegistrationRepository.findByEmail(email);
        if (voterOpt.isPresent()) {
            VoterRegistrationModel voter = voterOpt.get();
            voter.setEmailVerified(true);
            voterRegistrationRepository.save(voter);
            return true;
        }
        return false;
    }
}
