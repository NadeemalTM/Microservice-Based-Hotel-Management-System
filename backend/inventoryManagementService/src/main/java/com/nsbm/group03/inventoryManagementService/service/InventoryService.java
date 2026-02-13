package com.nsbm.group03.inventoryManagementService.service;

import com.nsbm.group03.inventoryManagementService.dto.InventoryItemDTO;
import com.nsbm.group03.inventoryManagementService.entity.InventoryItem;
import com.nsbm.group03.inventoryManagementService.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryItemDTO> getAllItem() {
        return inventoryRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public InventoryItemDTO addItem(InventoryItemDTO itemDTO) {
        InventoryItem item = mapToEntity(itemDTO);
        InventoryItem savedItem = inventoryRepository.save(item);
        return mapToDTO(savedItem);
    }

    public InventoryItemDTO updateStock(Long id, int amountUsed) {
        InventoryItem item = inventoryRepository.findById(id).orElseThrow();
        int newQuantity = item.getQuantity() - amountUsed;
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough stock");
        }
        item.setQuantity(newQuantity);
        InventoryItem updatedItem = inventoryRepository.save(item);
        return mapToDTO(updatedItem);
    }

    private InventoryItemDTO mapToDTO(InventoryItem item) {
        InventoryItemDTO dto = new InventoryItemDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setCategory(item.getCategory());
        dto.setQuantity(item.getQuantity());
        dto.setLowStock(item.getLowStock());
        return dto;
    }

    private InventoryItem mapToEntity(InventoryItemDTO dto) {
        InventoryItem item = new InventoryItem();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setCategory(dto.getCategory());
        item.setQuantity(dto.getQuantity());
        item.setLowStock(dto.getLowStock());
        return item;
    }

}
