package decorator.weapon

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

    fun performAttack(attackDecorator: AttackDecorator) {
        try {
            println("-------Attack-------")
            attackStrategy.attack(attackDecorator)
        } catch (e: UninitializedPropertyAccessException) {
            println("you cannot interface with this object")
        }
    }
}

interface AttackStrategy {
    fun attack(attackDecorator: AttackDecorator)
}

class ProjectileAttackStrategy : AttackStrategy {
    override fun attack(attackDecorator: AttackDecorator) {
        println("fire ${attackDecorator.description}")
        println(attackDecorator.getAttackProperty())
    }
}

class NonProjectileAttackStrategy : AttackStrategy {
    override fun attack(attackDecorator: AttackDecorator) {
        println("${attackDecorator.description} activated")
        println(attackDecorator.getAttackProperty())
    }
}