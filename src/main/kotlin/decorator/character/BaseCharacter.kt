package decorator.character

import decorator.GameObject
import decorator.common.AttackProperty
import decorator.system.SystemObject
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
            CharacterType.NORMAL -> NormalCharacter()
            CharacterType.VAMPIRE -> VampireCharacter()
            else -> {
                throw Exception("$characterType not yet implemented")
            }
        }
    }

    override fun createCharacter(characterType: CharacterType, systemObject: SystemObject): GameObject {
        return when (characterType) {
            CharacterType.NORMAL -> NormalCharacter(systemObject)
            CharacterType.VAMPIRE -> VampireCharacter(systemObject)
            else -> {
                throw Exception("$characterType not yet implemented")
            }
        }
    }
}

abstract class BaseCharacter : GameObject() {
    abstract var baseCharacterAttackProperty: AttackProperty
    private val weaponList = ArrayList<BaseWeapon>()
    private val powerUpList = ArrayList<BasePowerUp>()

    fun attack() {
        weaponList.forEach {
            it.performAttack(baseCharacterAttackProperty, powerUpList)
        }
    }

    fun addWeapon(weapon: BaseWeapon) {
        weaponList.add(weapon)
    }

    fun removeWeapon(weapon: BaseWeapon) {
        weaponList.remove(weapon)
    }

    fun addPowerUp(powerUp: BasePowerUp) {
        powerUpList.add(powerUp)
    }

    fun removePowerUp(powerUp: BasePowerUp) {
        powerUpList.remove(powerUp)
    }
}