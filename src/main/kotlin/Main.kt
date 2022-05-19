import strategy.*

fun main(args: Array<String>) {

    //GameObjectNoPattern
    println("GameObjectNoPattern")
    val talkCharacterNoPattern = TalkObject()
    talkCharacterNoPattern.interact()

    val attackCharacterNoPattern = AttackObject()
    attackCharacterNoPattern.interact()

    println("GameObjectNoPattern2")
    //GameObjectNoPattern2
    val talkCharacterNoPattern2 = GameObjectNoPattern2()
    val talkInteract = TalkInterface()
    talkCharacterNoPattern2.interact = talkInteract
    talkCharacterNoPattern2.interact.interact()

    val attackInterface = AttackInterface()
    talkCharacterNoPattern2.interact = attackInterface
    talkCharacterNoPattern2.interact.interact()


    println("GameObject Strategy Pattern")
    val attackCharacterNoPattern2 = AttackObject()
    attackCharacterNoPattern.interact()

    val character: GameObject = strategy.NPC()

    character.setInterfaceStrategy(TalkInteractStrategy())
    character.performInteract()

    character.setInterfaceStrategy(AttackInteractStrategy())
    character.performInteract()
}