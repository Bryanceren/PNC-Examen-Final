package com.uca.capas.dto;

import com.uca.capas.domain.Expediente;

import java.util.List;

public class ExpedienteJson {
    private List<ExpedienteDTO> data;

    public ExpedienteJson() { }

    public ExpedienteJson(List<ExpedienteDTO> data) {
        this.data = data;
    }

    public List<ExpedienteDTO> getData() {
        return data;
    }

    public void setData(List<ExpedienteDTO> data) {
        this.data = data;
    }
}
