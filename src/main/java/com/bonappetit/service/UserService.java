package com.bonappetit.service;

import com.bonappetit.model.entity.User;
import com.bonappetit.service.dtos.LoginUserDTO;
import com.bonappetit.service.dtos.RegisterUserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    boolean registerUser(RegisterUserDTO registerUserDTO);

    boolean loginUser(LoginUserDTO loginUserDTO);
}

