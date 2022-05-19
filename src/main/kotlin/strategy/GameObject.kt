package strategy

abstract class GameObject {

    private lateinit var interactStrategy: InteractStrategy

    fun setInterfaceStrategy(interactStrategy: InteractStrategy) {
        this.interactStrategy = interactStrategy
    }

    fun performInteract() {
        try {
            interactStrategy.interact()
        } catch (e: UninitializedPropertyAccessException) {
            println("nothing happened")
        }
    }
}

interface InteractStrategy {
    fun interact()
}

class TalkInteractStrategy : InteractStrategy {
    override fun interact() {
        println("\"Nice to meet you!\"")
    }
}

class AttackInteractStrategy : InteractStrategy {
    override fun interact() {
        println("you attacked by character")
    }
}

class NPC : GameObject() {

}


