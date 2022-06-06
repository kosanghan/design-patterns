import observer.SystemObject
import observer.OtherNPC
import observer.VampireNPC
import org.junit.Test

class ObserverTest {
    @Test
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
}