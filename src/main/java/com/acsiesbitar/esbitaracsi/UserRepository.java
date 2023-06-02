package com.acsiesbitar.esbitaracsi;
public interface UserRepository {
    User findByUsername(String username);
    User save(User user);

    User findById(String id);
}
