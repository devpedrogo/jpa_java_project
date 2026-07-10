package com.devpedrogo.jpa_project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devpedrogo.jpa_project.dto.LoginRequestDto;
import com.devpedrogo.jpa_project.dto.RegisterRequestDto;
import com.devpedrogo.jpa_project.dto.TokenResponseDto;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.service.AuthenticationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterRequestDto registerRequestDto) throws BadRequestException{
        authenticationService.criarAluno(registerRequestDto);
    }

    @PostMapping("/login")
    public TokenResponseDto login(@Valid @RequestBody LoginRequestDto loginRequestDto) throws Exception{
        return authenticationService.login(loginRequestDto);
    }
}
