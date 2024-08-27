package io.github.terminalemployeemanager.repository;

import io.github.terminalemployeemanager.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, String> {
    Optional<Registration> findByEmail(String email);
}
