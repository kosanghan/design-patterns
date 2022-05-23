package strategy

abstract class GameObjectNoPattern {
    abstract fun interact()
    var gameObjectData: GameObjectData = GameObjectData(this.javaClass.simpleName)
}

class NPGameObjectNPC : GameObjectNoPattern() {
    override fun interact() {
        println("[${gameObjectData.name}]:\"Nice to meet you!\"")
    }
}

class NPGameObjectEnemy : GameObjectNoPattern() {
    override fun interact() {
        println("you attacked by [${gameObjectData.name}]")
    }
}

class NPObjectRock : GameObjectNoPattern() {
    override fun interact() {
        //do nothing
    }
}