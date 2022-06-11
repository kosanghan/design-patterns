package decorator.weapon

import decorator.common.AttackDecorator
import decorator.common.AttackProperty

abstract class BaseWeapon : AttackDecorator() {
    abstract var baseWeaponAttackProperty: AttackProperty
    private lateinit var attackStrategy: AttackStrategy

    fun setAttackStrategy(attackStrategy: AttackStrategy) {
        this.attackStrategy = attackStrategy
    }

    fun getAttackStrategy(): AttackStrategy {
        return attackStrategy
    }

    fun performAttack(baseCharacterAttackProperty: AttackProperty, powerUpList: ArrayList<BasePowerUp>) {
        try {
            println("-------Attack-------")
            attackStrategy.attack(baseCharacterAttackProperty,powerUpList)
        } catch (e: UninitializedPropertyAccessException) {
            println("you cannot interface with this object")
        }
    }
}

interface AttackStrategy {
    fun attack(baseCharacterAttackProperty: AttackProperty, powerUpList: ArrayList<BasePowerUp>)
}

class ProjectileAttackStrategy : AttackStrategy {
    override fun attack(baseCharacterAttackProperty: AttackProperty, powerUpList: ArrayList<BasePowerUp>) {
        println("fire ${attackDecorator.description}")
        println(attackDecorator.getAttackProperty())
    }
}

class NonProjectileAttackStrategy : AttackStrategy {
    override fun attack(baseCharacterAttackProperty: AttackProperty, powerUpList: ArrayList<BasePowerUp>) {
        println("${attackDecorator.description} activated")
        println(attackDecorator.getAttackProperty())
    }
}