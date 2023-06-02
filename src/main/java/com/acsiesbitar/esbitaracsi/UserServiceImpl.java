package com.acsiesbitar.esbitaracsi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;


public class UserServiceImpl implements  UserService{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(UserRegistrationDTO registrationDTO) {
        // Perform validation here if needed

        // Check if the username already exists
        if (userRepository.findByUsername(registrationDTO.getUsername()) != null) {
            throw new RuntimeException("Username already exists.");
        }

        // Create a new user
        User user = new User();
        user.setName(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());

        // Encrypt the password
        String encodedPassword = passwordEncoder.encode(registrationDTO.getPassword());
        user.setPass(encodedPassword);

        // Save the user in the repository
        return userRepository.save(user);
    }

    @Override
    public User authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("User not found.");
        }

        // Check if the provided password matches the stored password
        if (!passwordEncoder.matches(password, user.getPass())) {
            throw new RuntimeException("Incorrect password.");
        }

        return user;
    }

    @Override
    public User getUserById(String id) {
        //optional is for null check returns
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findById(id));

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found.");
        }
        return optionalUser.get();
    }
}
