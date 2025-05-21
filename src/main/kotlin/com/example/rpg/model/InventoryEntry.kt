package com.example.rpg.model

import jakarta.persistence.*

@Entity
data class InventoryEntry(
    @Id @GeneratedValue val id: Long = 0,

    @ManyToOne
    val character: Character,

    @ManyToOne
    val item: Item,

    val quantity: Int
)