import decorator.character.BaseCharacterFactory
import decorator.character.CharacterType
import decorator.character.VampireCharacter
import decorator.system.SystemObject
import decorator.weapon.DamageUp
import decorator.weapon.Garlic
import decorator.weapon.Knife
import org.junit.Test

class DecoratorTest {
    @Test
    fun testDecoratorPattern() {
        val systemObject = SystemObject()
        val vampireChar =
            BaseCharacterFactory.createCharacter(CharacterType.VAMPIRE, systemObject) as VampireCharacter
        systemObject.registerObserver(vampireChar)

        vampireChar.addWeapon(Knife())
        vampireChar.addWeapon(Garlic())

        vampireChar.addPowerUp(DamageUp())

        vampireChar.attack()

        systemObject.changeDayNight()

        vampireChar.attack()
    }
}
