package com.voting.Repository;

import com.voting.Model.VoterLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoterLoginRepository extends JpaRepository<VoterLogin, Long> {
    Optional<VoterLogin> findByUsername(String username);
}