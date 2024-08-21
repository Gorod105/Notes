package org.example.notes.service;

import lombok.RequiredArgsConstructor;
import org.example.notes.model.User;
import org.example.notes.model.dto.request.SignupRequest;
import org.example.notes.repository.RoleRepository;
import org.example.notes.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String createUser(SignupRequest request) {
        if (userRepository.existsByUsername(request.getEmail())) {
            return "User with username: %s already exists".formatted(request.getEmail());
        }
        User user = new User();
        user.setUsername(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        roleRepository.findByName("ROLE_USER").ifPresent(user::addRole);
        userRepository.save(user);
        return "User created";
    }
    public User findByName(String username){
        return userRepository.findByUsername(username).orElseThrow();
    }

}
