package decorator

import decorator.system.SystemObjectDataReceiver
import util.DayNight

abstract class GameObject {

    var gameObjectData: GameObjectData = GameObjectData(this.javaClass.canonicalName)

    private lateinit var interactStrategy: InteractStrategy
    private lateinit var systemObjectDataReceiver: SystemObjectDataReceiver

    fun setInterfaceStrategy(interactStrategy: InteractStrategy) {
        this.interactStrategy = interactStrategy
    }

    fun setSystemObjectDataReceiver(systemObjectDataReceiver: SystemObjectDataReceiver) {
        this.systemObjectDataReceiver = systemObjectDataReceiver
    }

    fun performInteract() {
        try {
            interactStrategy.interact(gameObjectData)
        } catch (e: UninitializedPropertyAccessException) {
            println("you cannot interface with this object")
        }
    }

    fun performSystemDataReceive(dayOrNight: DayNight) {
        try {
            systemObjectDataReceiver.receiveDayOrNight(dayOrNight)
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
        println("[${gameObjectData.name}]:\"Nice to meet you!\"")
    }
}

class AttackInteractStrategy : InteractStrategy {
    override fun interact(gameObjectData: GameObjectData) {
        println("you attacked by [${gameObjectData.name}]")
    }
}

class ObtainInteractStrategy : InteractStrategy {
    override fun interact(gameObjectData: GameObjectData) {
        println("you obtained [${gameObjectData.name}]")
    }
}