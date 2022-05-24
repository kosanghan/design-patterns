package observer

import util.DayNight

abstract class GameObject {

    private var gameObjectData: GameObjectData = GameObjectData(this.javaClass.canonicalName)

    private lateinit var interactStrategy: InteractStrategy
    private lateinit var systemObjectDataReceiverPull: SystemObjectDataReceiverPull

    fun setInterfaceStrategy(interactStrategy: InteractStrategy) {
        this.interactStrategy = interactStrategy
    }

    fun setSystemObjectDataReceiverPull(systemObjectDataReceiverPull: SystemObjectDataReceiverPull) {
        this.systemObjectDataReceiverPull = systemObjectDataReceiverPull
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
            systemObjectDataReceiverPull.receiveDayOrNight()
        } catch (e: UninitializedPropertyAccessException) {
            println("this object does not have system object data pull receiver")
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

interface SystemObjectDataReceiverPull {
    fun receiveDayOrNight()
}

class VampireNPC() : GameObject(), SystemObjectDataReceiverPull {

    private lateinit var systemObject: SystemObject

    constructor(systemObject: SystemObject) : this() {
        this.systemObject = systemObject
        this.systemObject.registerObserver(this)
    }

    init {
        setSystemObjectDataReceiverPull(this)
    }

    override fun receiveDayOrNight() {
        setInterfaceStrategy(if (systemObject.getDayOrNight() == DayNight.DAY) TalkInteractStrategy() else AttackInteractStrategy())
    }
}

class OtherNPC : GameObject()