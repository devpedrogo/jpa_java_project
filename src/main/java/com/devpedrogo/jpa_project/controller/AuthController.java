package com.devpedrogo.jpa_project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import com.devpedrogo.jpa_project.dto.LoginRequestDto;
import com.devpedrogo.jpa_project.dto.RegisterRequestDto;
import com.devpedrogo.jpa_project.dto.TokenResponseDto;
import com.devpedrogo.jpa_project.service.AuthenticationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegisterRequestDto registerRequestDto){
        authenticationService.criarAluno(registerRequestDto);
    }

    @PostMapping("/register/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAdmin(@Valid @RequestBody RegisterRequestDto registerRequestDto){
        authenticationService.criarAdmin(registerRequestDto);
    }

    @PostMapping("/login")
    public TokenResponseDto login(@Valid @RequestBody LoginRequestDto loginRequestDto) throws Exception{
        return authenticationService.login(loginRequestDto);
    }
}
