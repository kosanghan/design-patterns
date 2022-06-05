package decorator.character

import decorator.GameObject
import decorator.system.SystemObjectDataReceiver
import decorator.weapon.BasePowerUp
import decorator.weapon.BaseWeapon
import util.DayNight

enum class CharacterType {
    NORMAL, VAMPIRE
}

interface CharacterFactory {
    fun createCharacter(characterType: CharacterType): Character
}

object BaseCharacterFactory : CharacterFactory {
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
    abstract var characterProperty: CharacterProperty
    private val weaponList = ArrayList<BaseWeapon>()
    private val powerUpLists = ArrayList<BasePowerUp>()

    protected fun showCharacterInfo(infoTitle: String) {
        println("-------$infoTitle------")
        println("[${gameObjectData.name}] : $characterProperty")
        println("weapons : ${weaponList.map { it.gameObjectData.name }}")
        println("powerUps : ${powerUpLists.map { it.gameObjectData.name }}")
    }

    fun attack() {
        weaponList.forEach {
            it.performAttack()
        }
    }

    fun addWeapon(weapon: BaseWeapon) {
        weaponList.add(weapon)
        showCharacterInfo("${weapon.javaClass.simpleName} added")
    }

    fun removeWeapon(weapon: BaseWeapon) {
        weaponList.remove(weapon)
    }

    fun addPowerUp(powerUp: BasePowerUp) {
        powerUpLists.add(powerUp)
    }

    fun removePowerUp(powerUp: BasePowerUp) {
        powerUpLists.remove(powerUp)
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
    override var characterProperty = CharacterProperty(0, 0, 0, 0, 0, 0)

    init {
        showCharacterInfo("${this.javaClass.simpleName} created")
    }
}

class VampireCharacter : Character(), SystemObjectDataReceiver {
    override var characterProperty = CharacterProperty(10, 10, 10, 10, 10, 10)

    init {
        showCharacterInfo("${this.javaClass.simpleName} created")
    }

    override fun receiveDayOrNight(dayOrNight: DayNight) {
        characterProperty = when (dayOrNight) {
            DayNight.DAY -> CharacterProperty(0, 0, 0, 0, 0, 0)
            else -> CharacterProperty(10, 10, 10, 10, 10, 10)
        }
    }
}