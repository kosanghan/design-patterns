package observer

import util.DayNight

abstract class GameObject {

    private var gameObjectData: GameObjectData = GameObjectData(this.javaClass.canonicalName)

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

interface SystemObjectDataReceiver {
    fun receiveDayOrNight(dayOrNight: DayNight)
}

class VampireNPC : GameObject(), SystemObjectDataReceiver {
    init {
        setSystemObjectDataReceiver(this)
    }

    override fun receiveDayOrNight(dayOrNight: DayNight) {
        setInterfaceStrategy(if (dayOrNight == DayNight.DAY) TalkInteractStrategy() else AttackInteractStrategy())
    }
}

class OtherNPC : GameObject()