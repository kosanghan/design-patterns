package decorator.weapon

import decorator.GameObject
import decorator.common.AttackProperty

abstract class BasePowerUp : GameObject() {

    abstract val powerUpAttackProperty: AttackProperty

    fun plusDamage() {

    }

    fun plusRange() {

    }

    fun plusDuration() {

    }

    fun accelerateCooltime() {

    }

    fun plusProjectileCount() {

    }

    fun plusProjectileSpeed() {

    }
}