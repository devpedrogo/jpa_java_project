package com.devpedrogo.jpa_project.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.devpedrogo.jpa_project.config.TokenProvider;
import com.devpedrogo.jpa_project.dto.LoginRequestDto;
import com.devpedrogo.jpa_project.dto.RegisterRequestDto;
import com.devpedrogo.jpa_project.dto.TokenResponseDto;
import com.devpedrogo.jpa_project.enums.RoleTypeEnum;
import com.devpedrogo.jpa_project.exception.BadRequestException;
import com.devpedrogo.jpa_project.model.AlunosEntity;
import com.devpedrogo.jpa_project.model.RolesEntity;
import com.devpedrogo.jpa_project.repository.IAlunosRepository;
import com.devpedrogo.jpa_project.repository.IRolesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IAlunosRepository alunosRepository;
    private final PasswordEncoder passwordEncoder;
    private final IRolesRepository rolesRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    @Value("${jwt.expiration}")
    private long expirationTime;


    public void criarAluno(RegisterRequestDto registerRequestDto){
          AlunosEntity aluno = alunosRepository.findByEmail(registerRequestDto.getEmail()).orElse(null);

          if(aluno != null){
              throw new BadRequestException("Aluno já cadastrado com esse email!");
          }

          RolesEntity role = rolesRepository.findByNome(RoleTypeEnum.ROLE_ALUNO.name())
                  .orElseGet(() -> rolesRepository.save(RolesEntity.builder()
                                                                    .nome(RoleTypeEnum.ROLE_ALUNO.name())
                                                                    .build()
                                                        ));

          AlunosEntity novoAluno = AlunosEntity.builder()
                  .nome(registerRequestDto.getNome())
                  .email(registerRequestDto.getEmail())
                  .roles(Set.of(role))
                  .senha(passwordEncoder.encode(registerRequestDto.getSenha()))
                  .build();

          alunosRepository.save(novoAluno);
    }

    public void criarAdmin(RegisterRequestDto registerRequestDto){
        AlunosEntity aluno = alunosRepository.findByEmail(registerRequestDto.getEmail()).orElse(null);

        if(aluno != null){
            throw new BadRequestException("Aluno já cadastrado com esse email!");
        }

        RolesEntity role = rolesRepository.findByNome(RoleTypeEnum.ROLE_ADMIN.name())
                .orElseGet(() -> rolesRepository.save(RolesEntity.builder()
                                                                  .nome(RoleTypeEnum.ROLE_ADMIN.name())
                                                                  .build()
                                                    ));

        AlunosEntity novoAluno = AlunosEntity.builder()
                .nome(registerRequestDto.getNome())
                .email(registerRequestDto.getEmail())
                .roles(Set.of(role))
                .senha(passwordEncoder.encode(registerRequestDto.getSenha()))
                .build();

        alunosRepository.save(novoAluno);
    }

    public TokenResponseDto login(LoginRequestDto loginRequestDto){
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getSenha()));

            //authentication provider -> userdetailsservice -> passwordEncoder.matches() -> autenticado

            String token = tokenProvider.gerarToken(authentication);

            return new TokenResponseDto(token, expirationTime);
        }catch(BadCredentialsException e){
            throw new BadRequestException("Credencias Inválidas");
        }catch(Exception e){
            throw e;
        }
    }
}
