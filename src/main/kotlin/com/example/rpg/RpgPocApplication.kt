package com.example.rpg

import com.example.rpg.model.Character
import com.example.rpg.model.InventoryEntry
import com.example.rpg.model.Item
import org.springframework.context.annotation.Bean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.rest.core.config.RepositoryRestConfigurer
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.web.servlet.config.annotation.CorsRegistry

@SpringBootApplication
class RpgPocApplication {

    @Bean
    fun repositoryRestConfigurer(): RepositoryRestConfigurer {
        return object : RepositoryRestConfigurer {
            override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration, cors: CorsRegistry) {
                config.exposeIdsFor(Character::class.java, Item::class.java, InventoryEntry::class.java)
            }
        }
    }

        fun main(args: Array<String>) {
            runApplication<RpgPocApplication>(*args)
        }
    }
