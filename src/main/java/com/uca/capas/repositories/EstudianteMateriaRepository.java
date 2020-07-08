package com.uca.capas.repositories;

import java.util.List;
import com.uca.capas.domain.EstudianteMateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EstudianteMateriaRepository extends JpaRepository<EstudianteMateria, Integer> {

    @Query(value = "select * from public.estudiante_materia where estudiante_fk = :codigo order by id", nativeQuery = true)
    public List<EstudianteMateria> findEstuMatList(@Param("codigo") Integer codigo);

    @Query(value = "select * from public.estudiante_materia where id = :codigo", nativeQuery = true)
    public EstudianteMateria findEstuMatId(@Param("codigo") Integer codigo);
    
}