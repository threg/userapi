package com.testetecnico.userapi.service;

import com.testetecnico.userapi.exeption.UserNotFoundException;
import com.testetecnico.userapi.model.User;
import com.testetecnico.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User newUser) {
        User existingUser = findById(id);
        existingUser.setName(newUser.getName());
        existingUser.setEmail(newUser.getEmail());

        if (newUser.getPassword() != null && !newUser.getPassword().isBlank()) {
            existingUser.setPassword(newUser.getPassword());
        }

        return userRepository.save(existingUser);
    }

    public void delete(Long id) {
        User existingUser = findById(id);
        userRepository.delete(existingUser);
    }
}
