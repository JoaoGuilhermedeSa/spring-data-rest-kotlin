package com.example.rpg.repository

import com.example.rpg.model.Character
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface CharacterRepository : CrudRepository<Character, Long>