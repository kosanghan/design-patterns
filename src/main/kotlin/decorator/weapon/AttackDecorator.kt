package decorator.weapon

import decorator.GameObject
import decorator.common.AttackProperty

abstract class AttackDecorator : GameObject() {
    lateinit var description: String
    abstract var attackType: AttackType

    abstract fun getAttackProperty(): AttackProperty

    enum class AttackType {
        PROJECTILE, NON_PROJECTILE, BOTH
    }
}