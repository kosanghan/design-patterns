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

abstract class BaseCharacter : GameObject() {
    abstract var characterAttackProperty: AttackProperty
    private val weaponList = ArrayList<BaseWeapon>()
    private val powerUpList = ArrayList<BasePowerUp>()

    protected fun showCharacterInfo(infoTitle: String) {
        println("-------$infoTitle------")
        println("[${gameObjectData.name}] : $characterAttackProperty")
        println("weapons : ${weaponList.map { it.gameObjectData.name }}")
        println("powerUps : ${powerUpList.map { it.gameObjectData.name }}")
    }

    fun attack() {
        weaponList.forEach {
            it.performAttack(characterAttackProperty)
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
    }

    fun removePowerUp(powerUp: BasePowerUp) {
        powerUpList.remove(powerUp)
    }
}