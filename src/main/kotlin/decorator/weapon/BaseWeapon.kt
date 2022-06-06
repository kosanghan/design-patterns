package decorator.weapon

import decorator.GameObject
import decorator.common.AttackProperty

abstract class BaseWeapon : GameObject() {
    abstract var baseWeaponAttackProperty: AttackProperty
    private lateinit var attackStrategy: AttackStrategy

    fun setAttackStrategy(attackStrategy: AttackStrategy) {
        this.attackStrategy = attackStrategy
    }

    fun performAttack(characterAttackProperty: AttackProperty) {
        try {
            println("-------Attack-------")
            attackStrategy.attack(this, characterAttackProperty)
        } catch (e: UninitializedPropertyAccessException) {
            println("you cannot interface with this object")
        }
    }
}

interface AttackStrategy {
    fun attack(weapon: BaseWeapon, characterAttackProperty: AttackProperty)
}

class ProjectileAttackStrategy : AttackStrategy {
    override fun attack(weapon: BaseWeapon, characterAttackProperty: AttackProperty) {
        val sumOfAttackProperty = weapon.baseWeaponAttackProperty + characterAttackProperty
        println("fire ${weapon.gameObjectData.name} $sumOfAttackProperty")
    }
}

class NonProjectileAttackStrategy : AttackStrategy {
    override fun attack(weapon: BaseWeapon, characterAttackProperty: AttackProperty) {
        val sumOfAttackProperty = weapon.baseWeaponAttackProperty + characterAttackProperty
        println("${weapon.gameObjectData.name} activated $sumOfAttackProperty")
    }
}