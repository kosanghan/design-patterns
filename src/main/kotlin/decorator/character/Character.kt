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

object NormalCharacterFactory : CharacterFactory {
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

abstract class Character : GameObject() {
    protected lateinit var characterProperty: CharacterProperty
    private val weaponList: List<Weapon> = ArrayList<Weapon>()
    private val powerUpList: List<PowerUp> = ArrayList<PowerUp>()

    fun attack() {
        weaponList.forEach {
            it.performAttack()
        }
    }

    init {
        println("${gameObjectData.name} created")
        println("status : ${characterProperty.toString()}")
        println("weapons : ${weaponList}")
        println("powerUps : ${powerUpList}")
    }
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
        this.characterProperty = CharacterProperty(0, 0, 0, 0, 0, 0)
    }

}

class VampireCharacter : Character(), SystemObjectDataReceiver {

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