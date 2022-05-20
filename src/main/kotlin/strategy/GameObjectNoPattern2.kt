package strategy

open class GameObjectNoPattern2 {
    var gameObjectData: GameObjectData = GameObjectData(this.javaClass.simpleName)
    fun getObjectInfo() {
        println("this is ${gameObjectData}")
    }

}

interface Interact {
    fun interact()
}

interface Interact2{
    fun interact2()
}

class NP2GameObjectNPC : GameObjectNoPattern2(), Interact, Interact2 {
    override fun interact() {
        println("[${gameObjectData.name}]:\"Nice to meet you!\"")
    }

    override fun interact2() {
        TODO("Not yet implemented")
    }
}

class NP2GameObjectEnemy : GameObjectNoPattern2(), Interact {
    override fun interact() {
        println("you attacked by [${gameObjectData.name}]")
    }
}

class NP2GameObjectRock : GameObjectNoPattern2() {
}