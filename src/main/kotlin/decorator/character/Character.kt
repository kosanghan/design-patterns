package decorator.character

import decorator.GameObject
import decorator.system.SystemObjectDataReceiver
import decorator.weapon.PowerUp
import decorator.weapon.Weapon
import util.DayNight

enum class CharacterType {
    NORMAL, VAMPIRE
}

interface CharacterFactory {
    fun createCharacter(characterType: CharacterType): Character
}

class NormalCharacterFactory : CharacterFactory {
    override fun createCharacter(characterType: CharacterType): Character {
        return when (characterType) {
            CharacterType.NORMAL -> NormalCharacter()
            CharacterType.VAMPIRE -> VampireCharacter()
            else -> {
                throw Exception("$characterType not yet implemented")
            }
        }
    }
}

abstract class Character : GameObject(), SystemObjectDataReceiver {
    protected lateinit var characterProperty: CharacterProperty
    protected val weaponList: List<Weapon> = ArrayList<Weapon>()
    protected val powerUpList: List<PowerUp> = ArrayList<PowerUp>()
}

data class CharacterProperty constructor(
    var damage: Int,
    var range: Int,
    var duration: Int,
    var cooltime: Int,
    var projectileCount: Int,
    var projectileSpeed: Int
)

class NormalCharacter : Character() {

    init {
        characterProperty = CharacterProperty(0, 0, 0, 0, 0, 0)
    }

    override fun receiveDayOrNight(dayOrNight: DayNight) {
        // do nothing
    }
}

class VampireCharacter : Character() {

    init {
        characterProperty = CharacterProperty(10, 10, 10, 10, 10, 10)
    }

    override fun receiveDayOrNight(dayOrNight: DayNight) {
        characterProperty = when (dayOrNight) {
            DayNight.DAY -> CharacterProperty(0, 0, 0, 0, 0, 0)
            else -> CharacterProperty(10, 10, 10, 10, 10, 10)
        }
    }
}