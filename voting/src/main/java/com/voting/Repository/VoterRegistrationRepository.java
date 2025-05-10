package com.voting.Repository;



import com.voting.Model.VoterRegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VoterRegistrationRepository extends JpaRepository<VoterRegistrationModel, Long> {

    Optional<VoterRegistrationModel> findByEmail(String email);

    Optional<VoterRegistrationModel> findByAadharNumber(String aadharNumber);
}

