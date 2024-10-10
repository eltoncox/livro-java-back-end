package com.elton.java.back.end.repository;

import com.elton.java.back.end.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByCpf(String cpf);

     List<User> findByNomeContainingIgnoreCase(String name);
}
