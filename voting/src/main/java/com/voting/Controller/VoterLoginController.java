package com.voting.Controller;

import com.voting.Model.VoterLogin;
import com.voting.Service.VoterLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voter-login")
public class VoterLoginController {
    @Autowired
    private VoterLoginService voterLoginService;

    @PostMapping("/register")
    public VoterLogin register(@RequestBody VoterLogin voter) {
        return voterLoginService.registerVoter(voter);
    }

    @PostMapping("/login")
    public VoterLogin login(@RequestBody VoterLogin voter) {
        return voterLoginService.loginVoter(voter.getUsername(), voter.getPassword());
    }
}