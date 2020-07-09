package com.uca.capas.dto;

import java.util.List;

public class MunicipioJson {
    private List<MunicipioDTO> data;

    public MunicipioJson() {
    }

    public MunicipioJson(List<MunicipioDTO> municipioDTOS) {
        this.data = municipioDTOS;
    }

    public List<MunicipioDTO> getData() {
        return data;
    }

    public void setData(List<MunicipioDTO> data) {
        this.data = data;
    }
}
