package io.github.terminalemployeemanager.service;

import io.github.terminalemployeemanager.entity.Registration;
import io.github.terminalemployeemanager.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public Optional<Registration> getManagerByEmail(String email) {
        if (registrationRepository.findByEmail(email).isPresent()) {
            return registrationRepository.findByEmail(email);
        } else {
            System.out.println("Manager with " + email + " not found");
            return Optional.empty();
        }

    }

    public void save(Registration registration) {
        registrationRepository.save(registration);
    }

}
