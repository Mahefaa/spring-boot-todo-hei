package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.model.SecUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecUserRepository extends JpaRepository<SecUser,Integer> {
  Optional<SecUser> findByUsername(String username);
}
