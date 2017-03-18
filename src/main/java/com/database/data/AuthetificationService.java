package com.database.data;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by wergin on 11-Mar-17.
 */
public class AuthetificationService {
    public Boolean existEmail(String email) {
        if (RegistrationRepository.getAllEmails().contains(email))
            return true;
        else return false;
    }

    public Boolean authetification(String email, String password) {
        RegistrationRepository registrationRepository = new RegistrationRepository();
        if ((existEmail(email).booleanValue()) && (registrationRepository.findPasswordByEmail(email).equals(password)))
            return true;
        return false;
    }
}
