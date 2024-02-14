package com.devsuperior.demo.dto;

import com.devsuperior.demo.entities.City;
import jakarta.validation.constraints.NotBlank;

public class CityDTO {

    private Long id;

    @NotBlank(message = "Campo requerido")
    private String name;

    public CityDTO() {
    }

    public CityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDTO(City entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
