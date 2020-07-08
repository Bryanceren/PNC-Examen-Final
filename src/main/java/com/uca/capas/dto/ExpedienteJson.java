package com.uca.capas.dto;

import com.uca.capas.domain.Expediente;

import java.util.List;

public class ExpedienteJson {
    private List<Expediente> data;

    public ExpedienteJson() { }

    public ExpedienteJson(List<Expediente> data) {
        this.data = data;
    }

    public List<Expediente> getData() {
        return data;
    }

    public void setData(List<Expediente> data) {
        this.data = data;
    }
}
