package observer

import util.toBoolean

abstract class GameObject {

    var gameObjectData: GameObjectData = GameObjectData(this.javaClass.canonicalName)

    private lateinit var interactStrategy: InteractStrategy
    private lateinit var systemObjectDataReceiver: SystemObjectDataReceiver

    fun setInterfaceStrategy(interactStrategy: InteractStrategy) {
        this.interactStrategy = interactStrategy
    }

    fun performInteract() {
        try {
            interactStrategy.interact(gameObjectData)
        } catch (e: UninitializedPropertyAccessException) {
            println("nothing happened")
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

class VampireNPC : GameObject(), SystemObjectDataReceiver {
    override fun receiveDayOrNight(dayOrNight: Int) {
        setInterfaceStrategy(if (dayOrNight.toBoolean()) TalkInteractStrategy() else AttackInteractStrategy())
    }
}