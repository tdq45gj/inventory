package com.example.shopify.model;

import com.example.shopify.dto.ItemDto;
import jdk.jfr.Label;
import org.springframework.context.annotation.Description;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Label("Item Id")
    private Integer id;

    @NotNull(message = "Item name cannot be null.")
    @Column(nullable = false)
    @Label("Name")
    private String name;

    @Label("Description")
    private String description;

    @NotNull(message = "Item price cannot be null.")
    @Column(nullable = false)
    @PositiveOrZero(message = "Price must be positive or zero.")
    @Label("Unit Price")
    private double price;

    @NotNull(message = "Item number cannot be null.")
    @Column(nullable = false)
    @PositiveOrZero(message = "Count must be positive or zero.")
    @Label("Count")
    private Integer count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Item(Integer id, String name, String description, double price, Integer count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    public Item(ItemDto itemDto) {
        this.id = itemDto.getId();
        this.name = itemDto.getName();
        this.description = itemDto.getDescription();
        this.price = itemDto.getPrice();
        this.count = itemDto.getCount();
    }

    public Item() {

    }
}
