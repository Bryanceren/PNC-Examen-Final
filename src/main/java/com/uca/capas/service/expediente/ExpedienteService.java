package com.uca.capas.service.expediente;

import com.uca.capas.domain.Expediente;
import com.uca.capas.dto.ExpedienteDTO;

import java.util.List;

public interface ExpedienteService {
    List<Expediente> findAllByName(String name);
    List<ExpedienteDTO> findExpedienteByName(String name);
}
