package com.uca.capas.service.expediente;

import com.uca.capas.domain.Expediente;

import java.util.List;

public interface ExpedienteService {
    List<Expediente> findAllByName(String name);
}
