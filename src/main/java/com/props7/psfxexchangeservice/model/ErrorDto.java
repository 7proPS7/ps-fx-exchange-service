package com.props7.psfxexchangeservice.model;

import java.time.LocalDateTime;

public class ErrorDto {
    private final LocalDateTime date;
    private final String description;

    public ErrorDto(LocalDateTime date, String description) {
        this.date = date;
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
