package org.example.notes.service;

import lombok.RequiredArgsConstructor;
import org.example.notes.dao.model.User;
import org.example.notes.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findByName(String username){
        return userRepository.findByUsername(username).orElseThrow();
    }
}
