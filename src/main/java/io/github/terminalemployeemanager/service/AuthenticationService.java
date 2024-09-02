package io.github.terminalemployeemanager.service;

import io.github.terminalemployeemanager.entity.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private BcryptService bcryptService;

    private final RegistrationService registrationService;
    @Autowired
    public AuthenticationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    public boolean authenticate(String email, String password) {
        Optional<Registration> registrationOptional = registrationService.getManagerByEmail(email);
        return registrationOptional.isPresent() && bcryptService.checkPasswordBcrypt(password, email);
    }

    public void register(String email, String firstName, String lastName, String password) {
        String hash_password = bcryptService.bCryptPassword(password);
        registrationService.save(new Registration(email, firstName, lastName, hash_password));
    }
}
