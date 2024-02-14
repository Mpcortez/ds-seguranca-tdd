package com.devsuperior.demo.dto;

import com.devsuperior.demo.entities.Event;

import java.time.LocalDate;

public class EventDTO {

    private Long id;
    private String name;
    private LocalDate date;
    private String url;
    private Long cityId;

    public EventDTO() {
    }

    public EventDTO(Long id, String name, LocalDate date, String url, Long cityId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.url = url;
        this.cityId = cityId;
    }

    public EventDTO(Event entity) {
        id = entity.getId();
        name = entity.getName();
        date = entity.getDate();
        url = entity.getUrl();
        cityId = entity.getCity().getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public Long getCityId() {
        return cityId;
    }
}
