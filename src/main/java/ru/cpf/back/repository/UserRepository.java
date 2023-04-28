package ru.cpf.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cpf.back.entity.AppUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
