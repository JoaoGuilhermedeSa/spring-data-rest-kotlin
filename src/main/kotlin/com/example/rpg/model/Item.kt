package com.example.rpg.model

import jakarta.persistence.*

@Entity
data class Item(
    @Id @GeneratedValue val id: Long = 0,
    val name: String,
    val type: String,
    val rarity: String
)