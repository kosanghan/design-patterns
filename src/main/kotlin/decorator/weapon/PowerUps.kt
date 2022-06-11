package decorator.weapon

import decorator.common.AttackProperty

class DamageUp : BasePowerUp() {
    override var basePowerUpAttackProperty = AttackProperty(10, 0, 0, 0, 0, 0)
    override var attackType = AttackType.BOTH

    init {
        if (baseWeapon?.getAttackStrategy() is ProjectileAttackStrategy)
            description = "DAMAGE UP " + baseWeapon?.description
    }


    override fun getAttackProperty(): AttackProperty {
    }
}