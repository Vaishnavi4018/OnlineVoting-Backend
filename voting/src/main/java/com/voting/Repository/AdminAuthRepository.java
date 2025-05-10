package com.voting.Repository;

import com.voting.Model.AdminAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminAuthRepository extends JpaRepository<AdminAuth, Long> {
    Optional<AdminAuth> findByPassword(String password);
}