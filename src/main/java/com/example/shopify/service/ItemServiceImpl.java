package com.example.shopify.service;

import com.example.shopify.dto.ItemDto;
import com.example.shopify.exception.DtoIdMismatchException;
import com.example.shopify.exception.ItemAlreadyExistsException;
import com.example.shopify.exception.ItemNotExistException;
import com.example.shopify.model.Item;
import com.example.shopify.repository.ItemRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Optional;

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
        if (itemDto.getId() != null && itemRepository.existsById(itemDto.getId())) {
            throw new ItemAlreadyExistsException("Item id #" + itemDto.getId() + " already exists.");
        }
        itemRepository.save(new Item(itemDto));
    }

    @Override
    public Item findItemById(Integer id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (!optionalItem.isPresent()) {
            throw new ItemNotExistException("Item id #" + id + " does not exist.");
        }
        return optionalItem.get();
    }

    @Override
    public void updateItem(Integer id, ItemDto itemDto) {
        if (id != itemDto.getId()) {
            throw new DtoIdMismatchException("Item id in request body does not match with id in path.");
        }
        Item item = new Item(itemDto);
        item.setId(id);
        if (!itemRepository.existsById(id)) {
            throw new ItemNotExistException("Item id #" + id + " does not exist.");
        }
        itemRepository.save(item);
    }

    @Override
    public void deleteItem(Integer id) {
        if (!itemRepository.existsById(id)) {
            throw new ItemNotExistException("Item id #" + id + " does not exist.");
        }
        itemRepository.deleteById(id);
    }

    @Override
    public void writeItemToCsv(Writer writer) {
        List<Item> items = listItems();
        try {
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            csvPrinter.printRecord("Item Id", "Name", "Description", "Count", "Price");
            for (Item item : items) {
                csvPrinter.printRecord(item.getId(), item.getName(), item.getDescription(), item.getCount(), item.getPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
