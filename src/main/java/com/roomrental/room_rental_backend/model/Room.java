package com.roomrental.room_rental_backend.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

@Entity
@Table(name= "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 500, message = "Desc must not exceed 500 chars")
    private String title;

    @Size(max = 500, message = "desc must not exceed 500 words")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "price must be greater than 0")
    private BigDecimal price;

    @NotBlank(message = "location is req")
    @Size(max = 200, message = "location must be less than 200 words")
    private String location;

    @Column(name = "is_available")
    private Boolean available = true;

    public Room() {}

    public Room(String title, String description, BigDecimal price, String location, Boolean available) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
