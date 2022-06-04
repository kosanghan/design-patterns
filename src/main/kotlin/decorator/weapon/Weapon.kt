package decorator.weapon

import decorator.GameObject

abstract class Weapon : GameObject() {
    abstract var damage: Int
    abstract var range: Int
    abstract var duration: Int
    abstract var cooltime: Int
    abstract var isProjectileCount: Boolean

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

interface AttackStrategy {
    fun attack(weapon: Weapon)
}

class ProjectileAttackStrategy : AttackStrategy {
    override fun attack(weapon: Weapon) {
        println("fire ${weapon.gameObjectData.name}")
    }
}

class NonProjectileAttackStrategy : AttackStrategy {
    override fun attack(weapon: Weapon) {
        println("${weapon.gameObjectData.name} activated")
    }
}