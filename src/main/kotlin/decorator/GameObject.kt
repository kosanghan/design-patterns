package decorator

interface SystemObjectDataReceiverPull {
    fun receiveDayOrNight()
}

abstract class GameObject {

    abstract var gameObjectData: GameObjectData

    private lateinit var interactStrategy: InteractStrategy
    private lateinit var systemObjectDataReceiver: SystemObjectDataReceiverPull

    fun setInterfaceStrategy(interactStrategy: InteractStrategy) {
        this.interactStrategy = interactStrategy
    }

    fun setSystemObjectDataReceiver(systemObjectDataReceiver: SystemObjectDataReceiverPull) {
        this.systemObjectDataReceiver = systemObjectDataReceiver
    }

    fun getSystemObjectDataReceiver(): SystemObjectDataReceiverPull {
        return systemObjectDataReceiver
    }

    fun performInteract() {
        try {
            interactStrategy.interact(gameObjectData)
        } catch (e: UninitializedPropertyAccessException) {
            println("you cannot interface with this object")
        }
    }

    fun performSystemDataReceive() {
        try {
            systemObjectDataReceiver.receiveDayOrNight()
        } catch (e: UninitializedPropertyAccessException) {
            println("this object does not have system object data receiver")
        }
    }
}

interface InteractStrategy {
    fun interact(gameObjectData: GameObjectData)
}

class TalkInteractStrategy : InteractStrategy {
    override fun interact(gameObjectData: GameObjectData) {
        println("[${gameObjectData.type}]:\"Nice to meet you!\"")
    }
}

class AttackInteractStrategy : InteractStrategy {
    override fun interact(gameObjectData: GameObjectData) {
        println("you attacked by [${gameObjectData.type}]")
    }
}

class ObtainInteractStrategy : InteractStrategy {
    override fun interact(gameObjectData: GameObjectData) {
        println("you obtained [${gameObjectData.type}]")
    }
}