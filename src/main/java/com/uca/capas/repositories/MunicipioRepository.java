package com.uca.capas.repositories;

import com.uca.capas.domain.Municipio;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MunicipioRepository  extends JpaRepository<Municipio,Integer> {
    @Query(nativeQuery = true,value = "select m.id, m.nombre as municipio, d.id as id_dpto from departamento d join municipio m on d.id = m.departamento_fk where d.id = :dptoId")
    List<Object[]> muncicipioDTO(Integer dptoId) throws DataAccessException;
}
