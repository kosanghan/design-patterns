import org.junit.Test
import strategy.*

class StrategyTest {
    @Test
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
}