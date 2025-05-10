package com.voting.Controller;



import com.voting.Model.VoterRegistrationModel;
import com.voting.Service.VoterRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/voter-registration")
@CrossOrigin(origins = "http://localhost:8080") // Adjust if frontend URL changes
public class VoterRegistrationController {

    @Autowired
    private VoterRegistrationService voterRegistrationService;

    @PostMapping("/register")
    public VoterRegistrationModel registerVoter(@RequestBody VoterRegistrationModel voter) {
        return voterRegistrationService.registerVoter(voter);
    }

    @GetMapping("/verify-email/{email}")
    public String verifyEmail(@PathVariable String email) {
        boolean verified = voterRegistrationService.verifyEmail(email);
        if (verified) {
            return "Email verified successfully!";
        } else {
            return "Email verification failed!";
        }
    }

    @GetMapping("/find-by-email/{email}")
    public Optional<VoterRegistrationModel> findVoterByEmail(@PathVariable String email) {
        return voterRegistrationService.findByEmail(email);
    }
}
