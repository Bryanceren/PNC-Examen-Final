package com.uca.capas.repositories;

import com.uca.capas.domain.Materia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MateriaRepository extends JpaRepository<Materia, Integer>
{
    public long count();

    public List<Materia> findAll(Sort sort);

    public Page<Materia> findAll(Pageable page);

    @Query(value = "select * from public.materia", nativeQuery = true)
    public List<Materia> findAllMaterias();

}