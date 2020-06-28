package com.uca.capas.repositories;

import java.util.List;

import com.uca.capas.domain.CentroEscolar;
import com.uca.capas.domain.Municipio;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CentroEscolarRepository extends JpaRepository<CentroEscolar, Integer> {
    public List<CentroEscolar> findByNombrecen(String Nombre_centro);


    @Query(value = "SELECT * from public.centro_escolar", nativeQuery = true)
    public List<CentroEscolar> findAllCentroEscolar();

    @Query(value = "SELECT * from public.municipio", nativeQuery = true)
    public List<Municipio> findAllMunicipios();

    @Query(value = "SELECT * from public.CentroEscolar where id = :CentroEscolar", nativeQuery = true)
    public CentroEscolar findCentroEscolarByIdcen(@Param("CentroEscolar") Integer CentroEscolar);

    public List<CentroEscolar> findAll(Sort sort);


    
}