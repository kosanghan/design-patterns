package strategy

abstract class GameObject {

    var gameObjectData: GameObjectData = GameObjectData(this.javaClass.canonicalName)

    protected lateinit var interactStrategy: InteractStrategy

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

class AnyObjectCanBe : GameObject() {
}

class TalkObject : GameObject() {
    init {
        interactStrategy = TalkInteractStrategy()
    }
}