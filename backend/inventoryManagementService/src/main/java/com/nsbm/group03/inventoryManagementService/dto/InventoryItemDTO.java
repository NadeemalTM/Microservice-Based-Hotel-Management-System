package com.nsbm.group03.inventoryManagementService.dto;

import lombok.Data;

@Data
public class InventoryItemDTO {
    private Long id;
    private String name;
    private String category;
    private int quantity;
    private int lowStock;
}
