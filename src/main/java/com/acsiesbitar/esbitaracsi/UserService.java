package com.acsiesbitar.esbitaracsi;

import org.springframework.stereotype.Repository;


import java.util.Collection;

@Repository
public interface UserService  {
    User registerUser(UserRegistrationDTO registrationDTO);
    User authenticateUser(String username, String password);

    User getUserById(String id);
}