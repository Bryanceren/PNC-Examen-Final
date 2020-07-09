package com.uca.capas.repositories;

import com.uca.capas.domain.Municipio;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MunicipioRepository  extends JpaRepository<Municipio,Integer> {
    @Query(nativeQuery = true,value = "select id,nombre from public.municipio")
    List<Object[]> muncicipioDTO() throws DataAccessException;
}
