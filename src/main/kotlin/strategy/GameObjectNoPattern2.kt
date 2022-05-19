package strategy

class GameObjectNoPattern2 {
    lateinit var interact: Interact
    lateinit var gameObjectData: GameObjectData
}

interface Interact {
    fun interact()
}

class TalkInterface : Interact {
    override fun interact() {
        println("\"Nice to meet you!\"")
    }
}

class AttackInterface : Interact {
    override fun interact() {
        println("you attacked by character")
    }
}

class InactiveInterface : Interact {
    override fun interact() {
        //do nothing
    }
}