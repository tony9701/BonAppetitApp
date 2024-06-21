package com.bonappetit.service.impl;

import com.bonappetit.config.UserSession;
import com.bonappetit.model.entity.User;
import com.bonappetit.repo.UserRepository;
import com.bonappetit.service.UserService;
import com.bonappetit.service.dtos.LoginUserDTO;
import com.bonappetit.service.dtos.RegisterUserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    @Override
    public boolean registerUser(RegisterUserDTO registerUserDTO) {

        //check if username or email are taken
        if (userRepository.existsByEmailOrUsername(registerUserDTO.getEmail(), registerUserDTO.getUsername())) {
            return false;
        }

        //check if passwords match
        if (!registerUserDTO.getPassword().equals(registerUserDTO.getConfirmPassword())) {
            return false;
        }

        User user = modelMapper.map(registerUserDTO, User.class);
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        userRepository.save(user);

        return true;
    }

    @Override
    public boolean loginUser(LoginUserDTO loginUserDTO) {

        //check if user exist
        Optional<User> byUsername = userRepository.findByUsername(loginUserDTO.getUsername());

        if (byUsername.isEmpty()) {
            return false;
        }

        if (!passwordEncoder.matches(loginUserDTO.getPassword(), byUsername.get().getPassword())) {
            return false;
        }

        userSession.login(byUsername.get());

        return true;
    }
}
