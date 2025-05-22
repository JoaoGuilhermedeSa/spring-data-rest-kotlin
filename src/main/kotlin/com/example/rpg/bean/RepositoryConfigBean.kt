package com.example.rpg.bean

import com.example.rpg.model.Character
import com.example.rpg.model.InventoryEntry
import com.example.rpg.model.Item
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
open class RepositoryConfigBean {

    @Bean
    open fun repositoryRestConfigurer(): RepositoryRestConfigurer {
        return object : RepositoryRestConfigurer {
            override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration, cors: CorsRegistry) {
                config.exposeIdsFor(Character::class.java, Item::class.java, InventoryEntry::class.java)
     //           config.basePath = "/api"
            }
        }
    }
}