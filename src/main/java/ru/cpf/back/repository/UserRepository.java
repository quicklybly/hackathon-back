package ru.cpf.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.cpf.back.entity.Admin;
import ru.cpf.back.entity.AppUser;
import ru.cpf.back.entity.Partner;
import ru.cpf.back.entity.Sportsman;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("SELECT s FROM Sportsman s WHERE s.id =:id")
    Optional<Sportsman> findSportsmenById(Long id);

    @Query("SELECT a FROM Admin a WHERE a.id =:id")
    Optional<Admin> findAdminById(Long id);

    @Query("SELECT p FROM Partner p WHERE p.id =:id")
    Optional<Partner> findPartnerById(Long id);
}
