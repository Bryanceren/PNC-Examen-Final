package com.uca.capas.dto;

import java.util.List;
import com.uca.capas.domain.EstudianteMateria;

public class EstudianteDTO {

    private List<EstudianteMateria> data;

    public EstudianteDTO(){}

    public EstudianteDTO(List<EstudianteMateria> data) {
        this.data = data;
    }

    public List<EstudianteMateria> getData() {
        return data;
    }

    public void setData(List<EstudianteMateria> data) {
        this.data = data;
    }
    
}