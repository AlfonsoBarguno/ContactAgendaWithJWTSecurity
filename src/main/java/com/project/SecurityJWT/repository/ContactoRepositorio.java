package com.project.SecurityJWT.repository;

import com.project.SecurityJWT.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Long> {
}
