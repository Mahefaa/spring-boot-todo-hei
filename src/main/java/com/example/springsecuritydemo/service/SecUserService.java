package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.model.SecUser;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SecUserService implements UserDetailsService {
  private com.example.springsecuritydemo.repository.SecUserRepository SecUserRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<SecUser> optSecUser = SecUserRepository.findByUsername(username);

    if(optSecUser.isPresent()){
      SecUser secUser = optSecUser.get();
      return new User(secUser.getUsername(),secUser.getPassword(), AuthorityUtils.createAuthorityList(secUser.getRole().name()));
    }
    throw new UsernameNotFoundException("UserName not found");
  }
}
