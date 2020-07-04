package com.uca.capas.repositories;

import com.uca.capas.domain.Materia;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MateriaRepository extends JpaRepository<Materia, Integer>
{
    public List<Materia> findAll(Sort sort);

    public long count();
}