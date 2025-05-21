package com.example.rpg.handler

import com.example.rpg.model.InventoryEntry
import com.example.rpg.repository.InventoryEntryRepository
import org.springframework.data.rest.core.annotation.HandleBeforeCreate
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.stereotype.Component

@Component
@RepositoryEventHandler(InventoryEntry::class)
class InventoryEntryEventHandler(
    private val inventoryEntryRepository: InventoryEntryRepository
) {
    @HandleBeforeCreate
    fun checkInventoryLimit(newEntry: InventoryEntry) {
        val character = newEntry.character
        val existingItems = inventoryEntryRepository.findAll()
            .filter { it.character.id == character.id }
            .sumOf { it.quantity }

        if (existingItems + newEntry.quantity > 10) {
            throw IllegalStateException("O personagem não pode carregar mais de 10 itens no total.")
        }
    }
}