package io.github.terminalemployeemanager.service;

import com.password4j.BcryptFunction;
import com.password4j.Hash;
import com.password4j.Password;
import com.password4j.types.Bcrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BcryptService {
    private final RegistrationService registrationService;
    @Autowired
    public BcryptService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    public Boolean checkPasswordBcrypt(String password, String email) {
        BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);
        return Password.check(password, registrationService.getManagerByEmail(email).get().getPassword()).with(bcrypt);
    }

    public String bCryptPassword(String password) {
        BcryptFunction bcrypt = BcryptFunction.getInstance(Bcrypt.B, 12);
        Hash hash_password = Password.hash(password).with(bcrypt);
        return hash_password.getResult();
    }
}
