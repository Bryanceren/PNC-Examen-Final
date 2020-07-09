package com.uca.capas.repositories;

import com.uca.capas.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento,Integer> {
    List<Departamento> findAll();
}
