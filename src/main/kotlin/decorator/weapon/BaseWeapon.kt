package decorator.weapon

import decorator.GameObject

abstract class BaseWeapon : GameObject() {
    abstract var baseWeaponProperty: BaseWeaponProperty
    private lateinit var attackStrategy: AttackStrategy

    fun setAttackStrategy(attackStrategy: AttackStrategy) {
        this.attackStrategy = attackStrategy
    }

    fun performAttack() {
        try {
            attackStrategy.attack(this)
        } catch (e: UninitializedPropertyAccessException) {
            println("you cannot interface with this object")
        }
    }
}

data class BaseWeaponProperty constructor(
    var damage: Int,
    var range: Int,
    var duration: Int,
    var cooltime: Int,
    var projectileCount: Int,
    var projectileSpeed: Int
)

interface AttackStrategy {
    fun attack(weapon: BaseWeapon)
}

class ProjectileAttackStrategy : AttackStrategy {
    override fun attack(weapon: BaseWeapon) {
        println("fire ${weapon.gameObjectData.name} ${weapon.baseWeaponProperty}")
    }
}

class NonProjectileAttackStrategy : AttackStrategy {
    override fun attack(weapon: BaseWeapon) {
        println("${weapon.gameObjectData.name} activated ${weapon.baseWeaponProperty}")
    }
}