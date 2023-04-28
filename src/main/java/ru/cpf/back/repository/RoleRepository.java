package ru.cpf.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cpf.back.entity.Role;
import ru.cpf.back.entity.enums.RoleEnum;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum roleEnum);
}
