package com.company.repository;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> loadUserByUsername(String username);

    boolean existsByUsername(String username);

}
