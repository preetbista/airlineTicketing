package com.airline.airlineticketing.service.impl;

import com.airline.airlineticketing.dto.UserDto;
import com.airline.airlineticketing.model.User;
import com.airline.airlineticketing.repository.UserRepository;
import com.airline.airlineticketing.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDTO) {
        User user = new User(userDTO.getUsername(),
                userDTO.getPassword(), userDTO.getMobileNumber(), userDTO.getRole());
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getId(), savedUser.getUserName(),
                savedUser.getPassword(), savedUser.getMobileNumber(), savedUser.getRole());
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new UserDto(user.getId(), user.getUserName(),
                    user.getPassword(), user.getMobileNumber(), user.getRole());
        } else {
            return null;
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(new UserDto(user.getId(), user.getUserName(), user.getPassword(), user.getMobileNumber(), user.getRole()));
        }
        return userDTOs;
    }

    @Override
    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return false;
    }
}
