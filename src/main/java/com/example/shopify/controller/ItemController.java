package com.example.shopify.controller;

import com.example.shopify.common.ApiReponse;
import com.example.shopify.dto.ItemDto;
import com.example.shopify.model.Item;
import com.example.shopify.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public @NotNull List<Item> list() {
        return itemService.listItems();
    }

    @PostMapping("/add")
    public ResponseEntity<ApiReponse> addItem(@RequestBody ItemDto itemDto) {
        itemService.addItem(itemDto);
        return new ResponseEntity<>(new ApiReponse(true, "A new item has been added."), HttpStatus.CREATED);
    }

    @PostMapping("/delete/{itemId}")
    public ResponseEntity<ApiReponse> getItemById(@PathVariable("itemId") Integer id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(new ApiReponse(true, "An item has been deleted."), HttpStatus.ACCEPTED);
    }

    @PostMapping("/update/{itemId}")
    public ResponseEntity<ApiReponse> updateItemById(@PathVariable("itemId") Integer id, @RequestBody ItemDto itemDto) {
        itemService.updateItem(id, itemDto);
        return new ResponseEntity<>(new ApiReponse(true, "An item has been updated."), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{itemId}")
    public Item findItemById(@PathVariable("itemId") Integer id) {
        return itemService.findItemById(id);
    }
}
