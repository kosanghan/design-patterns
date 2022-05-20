import strategy.*

fun main(args: Array<String>) {
    testStrategyPattern()
}

fun testStrategyPattern() {
    println("GameObjectNoPattern")
    val npc = NPGameObjectNPC()
    npc.interact()

    val enemy = NPGameObjectEnemy()
    enemy.interact()
    println()

    println("GameObjectNoPattern2")
    val npc2 = NP2GameObjectNPC()
    npc2.interact()

    val enemy2 = NP2GameObjectEnemy()
    enemy2.interact()
    println()

    println("GameObject Strategy Pattern")
    val rock: GameObject = AnyObjectCanBe()

    rock.setInterfaceStrategy(TalkInteractStrategy())
    rock.performInteract()

    rock.setInterfaceStrategy(AttackInteractStrategy())
    rock.performInteract()
}