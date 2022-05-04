package com.dh.clinicaFinal.repository;


import com.dh.clinicaFinal.model.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepositoy extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);
}