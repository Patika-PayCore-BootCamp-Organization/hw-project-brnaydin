package com.blog.blog.repository;

import com.blog.blog.model.DictTypeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DictTypeUserRepository extends JpaRepository<DictTypeUser, Long> {

    Optional<DictTypeUser> findByCode(String code);

}
