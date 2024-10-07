package com.ezze.restfulapi.repository;

import com.ezze.restfulapi.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long> {

    // Consulta con JPQL
    @Query("SELECT l FROM Local l WHERE l.name = :name")
    Optional<Local> findLocalByNameWithJPQL(String name);

    // Consulta con inversion de control
    Optional<Local> findByName(String name);

    // Consulta ignorando mayusculas y minusculas
    Optional<Local> findByNameIgnoreCase(String name);

    Local findLocalById(Long id);
}
