package com.uca.capas.repositories;

import java.util.List;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Municipio;

<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
import org.springframework.dao.DataAccessException;
>>>>>>> rama-dona
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CentroEscolarRepository extends JpaRepository<CentroEscolar, Integer>
{
    @Query(value = "SELECT * from public.centro_escolar", nativeQuery = true)
    public List<CentroEscolar> findAllCentroEscolar();

    @Query(value = "SELECT * from public.municipio", nativeQuery = true)
    public List<Municipio> findAllMunicipios();

    public long count();

    @Query(value = "SELECT * from public.centro_escolar where municipio_fk=:fk", nativeQuery = true)
    public List<CentroEscolar> findCentroPorMuni(Integer fk);

    public List<CentroEscolar> findAll(Sort sort);
    public Page<CentroEscolar> findAll(Pageable page);


    CentroEscolar findByIdcen(Integer code);



}