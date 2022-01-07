package com.example.shopify.dto;

import com.example.shopify.model.Item;

import javax.validation.constraints.NotNull;

public class ItemDto {
    private Integer id;
    @NotNull(message = "Item name cannot be null.")
    private String name;
    private String description;
    @NotNull(message = "Item price cannot be null.")
    private double price;
    @NotNull(message = "Item number cannot be null.")
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

    public ItemDto(@NotNull Integer id, @NotNull String name, String description, @NotNull double price, @NotNull Integer count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    public ItemDto() {

    }

    public ItemDto(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.count = item.getCount();
    }
}
