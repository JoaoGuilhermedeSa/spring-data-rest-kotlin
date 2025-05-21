package com.example.rpg.repository

import com.example.rpg.model.InventoryEntry
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface InventoryEntryRepository : CrudRepository<InventoryEntry, Long>