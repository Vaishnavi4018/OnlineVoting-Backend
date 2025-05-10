package com.voting.Controller;

import com.voting.Model.CandidateRegistration;
import com.voting.Service.CandidateRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidate-registration")
public class CandidateRegistrationController {
    @Autowired
    private CandidateRegistrationService candidateRegistrationService;

    // Endpoint to add a new candidate (POST operation for "ADD CANDIDATE")
    @PostMapping("/add")
    public CandidateRegistration addCandidate(@RequestBody CandidateRegistration candidate) {
        return candidateRegistrationService.addCandidate(candidate);
    }
}