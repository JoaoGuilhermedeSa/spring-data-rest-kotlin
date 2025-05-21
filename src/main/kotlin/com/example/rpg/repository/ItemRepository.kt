package com.example.rpg.repository

import com.example.rpg.model.Item
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface ItemRepository : CrudRepository<Item, Long>