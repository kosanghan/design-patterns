import decorator.character.BaseCharacterFactory
import decorator.character.CharacterType
import decorator.character.VampireBaseCharacter
import decorator.system.SystemObject
import decorator.weapon.Garlic
import decorator.weapon.Knife
import org.junit.Test

class DecoratorTest {
    @Test
    fun testDecoratorPattern() {
        val systemObject = SystemObject()
        val vampireChar =
            BaseCharacterFactory.createCharacter(CharacterType.VAMPIRE, systemObject) as VampireBaseCharacter
        systemObject.registerObserver(vampireChar)

        vampireChar.addWeapon(Knife())
        vampireChar.addWeapon(Garlic())

        vampireChar.attack()

        systemObject.changeDayNight()

        vampireChar.attack()
    }
}
