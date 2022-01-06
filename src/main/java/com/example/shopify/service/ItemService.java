package com.example.shopify.service;

import com.example.shopify.dto.ItemDto;
import com.example.shopify.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {
    public List<Item> listItems();
    public void addItem(ItemDto itemDto);
    public Item findItemById(Integer id);
    public void updateItem(Integer id, ItemDto itemDto);
    public void deleteItem(Integer id);
}
