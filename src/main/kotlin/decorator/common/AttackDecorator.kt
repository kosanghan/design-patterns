package decorator.common

import decorator.GameObject

abstract class AttackDecorator : GameObject() {
    lateinit var description: String
    abstract var attackType: AttackType

    abstract fun getAttackProperty(): AttackProperty

    enum class AttackType {
        PROJECTILE, NON_PROJECTILE, BOTH
    }
}