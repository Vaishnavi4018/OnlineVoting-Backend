package com.voting.Repository;

import com.voting.Model.CandidateRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRegistrationRepository extends JpaRepository<CandidateRegistration, Long> {
}