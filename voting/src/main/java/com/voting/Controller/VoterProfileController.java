package com.voting.Controller;

import com.voting.Model.VoterProfile;
import com.voting.Service.VoterProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voter-profile")
public class VoterProfileController {
    @Autowired
    private VoterProfileService voterProfileService;

    // Endpoint to fetch voter profile (GET operation)
    @GetMapping("/profile/{id}")
    public VoterProfile getVoterProfile(@PathVariable Long id) {
        return voterProfileService.getVoterProfile(id);
    }

    // Endpoint to update voter profile (POST operation for "Edit Profile")
    @PostMapping("/profile/{id}")
    public VoterProfile updateVoterProfile(@PathVariable Long id, @RequestBody VoterProfile voterProfile) {
        return voterProfileService.updateVoterProfile(id, voterProfile);
    }

    // Endpoint to create a voter profile (optional, for initial setup)
    @PostMapping("/create")
    public VoterProfile createVoterProfile(@RequestBody VoterProfile voterProfile) {
        return voterProfileService.createVoterProfile(voterProfile);
    }
}
