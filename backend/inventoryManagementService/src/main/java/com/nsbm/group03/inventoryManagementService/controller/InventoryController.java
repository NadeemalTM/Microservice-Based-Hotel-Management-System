package com.nsbm.group03.inventoryManagementService.controller;

import com.nsbm.group03.inventoryManagementService.dto.InventoryItemDTO;
import com.nsbm.group03.inventoryManagementService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<InventoryItemDTO> getInventory() {
        return inventoryService.getAllItem();
    }

    @PostMapping
    public InventoryItemDTO createItem(@RequestBody InventoryItemDTO item) {
        return inventoryService.addItem(item);
    }

    @PutMapping("/{id}/consume")
    public InventoryItemDTO consumeItem(@PathVariable Long id, @RequestParam int amountUsed) {
        return inventoryService.updateStock(id, amountUsed);
    }

}
