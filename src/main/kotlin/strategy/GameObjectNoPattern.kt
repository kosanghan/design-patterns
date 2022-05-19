package strategy

abstract class GameObjectNoPattern {
    abstract fun interact()
    lateinit var gameObjectData: GameObjectData
}

class TalkObject : GameObjectNoPattern() {
    override fun interact() {
        println("\"Nice to meet you!\"")
    }
}

class AttackObject : GameObjectNoPattern() {
    override fun interact() {
        println("you attacked by character")
    }
}

class InactiveObject : GameObjectNoPattern() {
    override fun interact() {
        //do nothing
    }
}