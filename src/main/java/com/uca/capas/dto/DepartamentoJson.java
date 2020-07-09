package com.uca.capas.dto;

import com.uca.capas.domain.Departamento;

import java.util.List;

public class DepartamentoJson {
    private List<Departamento> departamentos;

    public DepartamentoJson() {
    }

    public DepartamentoJson(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
