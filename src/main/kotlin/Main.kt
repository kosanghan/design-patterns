import decorator.character.BaseCharacterFactory
import decorator.character.CharacterType
import decorator.weapon.Garlic
import decorator.weapon.Knife
import observer.OtherNPC
import observer.SystemObject
import observer.VampireNPC
import strategy.*

fun main(args: Array<String>) {
//    testStrategyPattern()
//    testObserverPattern()
    testDecoratorPattern()
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
    var vampire = VampireNPC()
    vampire = VampireNPC(systemObject)

    println()
    println("register vampire to system object")
    systemObject.registerObserver(vampire)
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
    systemObject.removeObserver(vampire)
    systemObject.changeDayNight()
    vampire.performInteract()

    println()
    println("registered other object not using observer pattern")
    val normal = OtherNPC()
    systemObject.registerObserver(normal)
    systemObject.changeDayNight()
    normal.performInteract()
}

fun testDecoratorPattern() {
    val character = BaseCharacterFactory.createCharacter(CharacterType.NORMAL)
    character.addWeapon(Knife())
    character.addWeapon(Garlic())

    character.attack()
    character.performInteract()
}