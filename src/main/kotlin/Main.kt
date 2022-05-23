import observer.OtherNPC
import observer.SystemObject
import observer.VampireNPC
import strategy.*

fun main(args: Array<String>) {
//    testStrategyPattern()
    testObserverPattern()
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
    val npc3: GameObject = AnyObjectCanBe()

    npc3.setInterfaceStrategy(TalkInteractStrategy())
    npc3.performInteract()

    npc3.setInterfaceStrategy(AttackInteractStrategy())
    npc3.performInteract()
}

fun testObserverPattern() {
    println("GameObject Strategy Pattern")
    val systemObject = SystemObject()
    val vampire = VampireNPC()

    println()
    println("register vampire to system object")
    systemObject.registerGameObject(vampire)
    vampire.performInteract()

    println()
    println("day night changed")
    systemObject.changeDayNight()
    vampire.performInteract()

    println()
    println("day night changed")
    systemObject.changeDayNight()
    vampire.performInteract()

    println()
    println("unregister vampire from system object")
    systemObject.unregisterGameObject(vampire)
    systemObject.changeDayNight()
    vampire.performInteract()

    println()
    println("registered other object not using observer pattern")
    val normal = OtherNPC()
    systemObject.registerGameObject(normal)
    systemObject.changeDayNight()
    normal.performInteract()
}