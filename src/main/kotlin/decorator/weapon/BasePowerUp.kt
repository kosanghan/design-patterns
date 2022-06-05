package decorator.weapon

import decorator.GameObject

abstract class BasePowerUp : GameObject() {

    abstract val powerUpProperty: BasePowerUpProperty

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

data class BasePowerUpProperty constructor(
    var damage: Int,
    var range: Int,
    var duration: Int,
    var cooltime: Int,
    var projectileCount: Int,
    var projectileSpeed: Int
)