package com.uca.capas.dto;

import com.uca.capas.domain.Expediente;

import java.util.List;

public class ExpedienteDTO {
    private List<Expediente> data;

    public ExpedienteDTO() { }

    public ExpedienteDTO(List<Expediente> data) {
        this.data = data;
    }

    public List<Expediente> getData() {
        return data;
    }

    public void setData(List<Expediente> data) {
        this.data = data;
    }
}
