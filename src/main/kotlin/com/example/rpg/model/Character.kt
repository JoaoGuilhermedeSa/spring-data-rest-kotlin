package com.example.rpg.model

import jakarta.persistence.*

@Entity
data class Character(
    @Id @GeneratedValue val id: Long = 0,
    val name: String,
    val characterClass: String,
    val level: Int,
    val hp: Int
)