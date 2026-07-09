package com.devpedrogo.jpa_project.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devpedrogo.jpa_project.repository.IAlunosRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
  
  private final IAlunosRepository alunosRepository;
  //IMPLEMENTAR ALUNOS ENTITYYYY
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return alunosRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));
  }

}
