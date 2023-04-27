package ru.cpf.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cpf.back.entity.Tag;

import java.nio.file.LinkOption;
import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
