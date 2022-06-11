package decorator

data class GameObjectData(val type: GameObjectType) {
}

enum class GameObjectType {
    CHARACTER, NPC, WEAPON, POWER_UP
}