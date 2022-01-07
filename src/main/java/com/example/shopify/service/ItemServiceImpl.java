package com.example.shopify.service;

import com.example.shopify.dto.ItemDto;
import com.example.shopify.model.Item;
import com.example.shopify.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> listItems() {
        return itemRepository.findAll();
    }

    @Override
    public void addItem(ItemDto itemDto) {
        itemRepository.save(new Item(itemDto));
    }

    @Override
    public Item findItemById(Integer id) {
        return itemRepository.getById(id);
    }

    @Override
    public void updateItem(Integer id, ItemDto itemDto) {
        Item item = new Item(itemDto);
        item.setId(id);
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Integer id) {
        itemRepository.deleteById(id);
    }
}
