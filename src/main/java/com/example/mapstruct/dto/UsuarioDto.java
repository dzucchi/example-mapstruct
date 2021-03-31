package com.example.mapstruct.dto;

import com.example.mapstruct.entity.Area;

import java.util.List;
import java.util.Set;

public class UsuarioDto {

    private String nome;
    private Integer idade;
    private List<AreaDto> areas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<AreaDto> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaDto> areas) {
        this.areas = areas;
    }
}
