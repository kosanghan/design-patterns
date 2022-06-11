package decorator.character

import decorator.GameObject
import decorator.system.SystemObject
import decorator.weapon.AttackDecorator
import decorator.weapon.BasePowerUp
import decorator.weapon.BaseWeapon

enum class CharacterType {
    NORMAL, VAMPIRE
}

interface CharacterFactory {
    fun createCharacter(characterType: CharacterType): GameObject
    fun createCharacter(characterType: CharacterType, systemObject: SystemObject): GameObject
}

object BaseCharacterFactory : CharacterFactory {
    override fun createCharacter(characterType: CharacterType): GameObject {
        return when (characterType) {
            CharacterType.NORMAL -> NormalBaseCharacter()
            CharacterType.VAMPIRE -> VampireBaseCharacter()
            else -> {
                throw Exception("$characterType not yet implemented")
            }
        }
    }

    override fun createCharacter(characterType: CharacterType, systemObject: SystemObject): GameObject {
        return when (characterType) {
            CharacterType.NORMAL -> NormalBaseCharacter(systemObject)
            CharacterType.VAMPIRE -> VampireBaseCharacter(systemObject)
            else -> {
                throw Exception("$characterType not yet implemented")
            }
        }
    }
}

abstract class BaseCharacter : AttackDecorator() {
    private val weaponList = ArrayList<BaseWeapon>()
    private val powerUpList = ArrayList<BasePowerUp>()

    protected fun showCharacterInfo(infoTitle: String) {
        println("-------$infoTitle------")
        println("weapons : ${weaponList.map { it.gameObjectData.name }}")
    }

    fun attack() {
        weaponList.forEach {
            it.performAttack(this)
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
        powerUpList.add(powerUp)
        weaponList.forEach {
            powerUp.setBaseWeapon(it)
        }
        showCharacterInfo("${powerUp.javaClass.simpleName} added")
    }

    fun removePowerUp(powerUp: BasePowerUp) {
        powerUpList.remove(powerUp)
    }
}