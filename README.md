# 🧙 RPG POC com Spring Data REST e Kotlin

Este projeto é uma Prova de Conceito (POC) usando **Spring Data REST** com **Kotlin** para representar um sistema simples de RPG com personagens, itens e inventário.

## 🔧 Tecnologias

- Kotlin
- Spring Boot 3.x
- Spring Data JPA
- Spring Data REST
- H2 Database (em memória)
- Maven

## 🗂️ Entidades

### `Character`
Representa um personagem jogável.

| Campo | Tipo |
|-------|------|
| id | Long |
| name | String |
| characterClass | String |
| level | Int |
| hp | Int |

### `Item`
Representa um item que pode ser armazenado no inventário.

| Campo | Tipo |
|-------|------|
| id | Long |
| name | String |
| type | String |
| rarity | String |

### `InventoryEntry`
Relaciona personagens a itens com quantidade.

| Campo | Tipo |
|-------|------|
| id | Long |
| character | Character (ManyToOne) |
| item | Item (ManyToOne) |
| quantity | Int |

## 📜 Regra de Negócio

> Um personagem **não pode carregar mais que 10 itens no total** (somando as quantidades).

Essa regra é aplicada via `@RepositoryEventHandler` antes da criação (`POST`) de uma nova entrada de inventário.

## ▶️ Como rodar

```bash
./mvnw spring-boot:run
```

Acesse o H2 Console (útil para debug):
```
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
```

## 📡 Endpoints REST

Base path: `/api`

### 🔹 Criar personagem

```bash
curl -X POST http://localhost:8080/api/characters \
  -H "Content-Type: application/json" \
  -d '{
        "name": "Arthas",
        "characterClass": "Paladin",
        "level": 10,
        "hp": 100
      }'
```

### 🔹 Criar item

```bash
curl -X POST http://localhost:8080/api/items \
  -H "Content-Type: application/json" \
  -d '{
        "name": "Espada Longa",
        "type": "Weapon",
        "rarity": "Common"
      }'
```

### 🔹 Adicionar item ao inventário

```bash
curl -X POST http://localhost:8080/api/inventoryEntries \
  -H "Content-Type: application/json" \
  -d '{
        "character": "/api/characters/1",
        "item": "/api/items/1",
        "quantity": 3
      }'
```

### ⚠️ Exemplo que falha por exceder o limite de 10 itens

```bash
curl -X POST http://localhost:8080/api/inventoryEntries \
  -H "Content-Type: application/json" \
  -d '{
        "character": "/api/characters/1",
        "item": "/api/items/1",
        "quantity": 11
      }'
```

Resposta esperada:
```json
{
  "message": "O personagem não pode carregar mais de 10 itens no total."
}
```

## 📁 Estrutura do Projeto

```
rpg-poc/
├── model/
│   ├── Character.kt
│   ├── Item.kt
│   └── InventoryEntry.kt
├── repository/
│   ├── CharacterRepository.kt
│   ├── ItemRepository.kt
│   └── InventoryEntryRepository.kt
├── handler/
│   └── InventoryEntryEventHandler.kt
├── resources/
│   └── application.properties
├── RpgPocApplication.kt
└── pom.xml
```

---

## 🧠 Expansões futuras

- Controle de nível com base nos itens raros.
- Sistema de batalhas e experiência.
- API customizada com endpoints agregados.