package decorator.weapon

import decorator.common.AttackDecorator
import decorator.common.AttackProperty

abstract class BasePowerUp : AttackDecorator() {
    private var baseWeapon: BaseWeapon? = null
    abstract var basePowerUpAttackProperty: AttackProperty
    protected lateinit var attackPropertyStrategy: GetAttackPropertyStrategy

    fun setBaseWeapon(baseWeapon: BaseWeapon) {
        this.baseWeapon = baseWeapon
        attackPropertyStrategy = getAttackPropertyStrategy(baseWeapon)
    }

    fun getBaseWeapon(): BaseWeapon? {
        return baseWeapon
    }

    private fun getAttackPropertyStrategy(baseWeapon: BaseWeapon): GetAttackPropertyStrategy {
        return when (baseWeapon.getAttackStrategy()) {
            is ProjectileAttackStrategy -> GetProjectileAttackPropertyStrategy()
            else -> GetNonProjectileAttackPropertyStrategy()
        }
    }
}

interface GetAttackPropertyStrategy {
    fun getAttackProperty(weapon: AttackDecorator, powerUp: AttackDecorator): AttackProperty
}

class GetProjectileAttackPropertyStrategy : GetAttackPropertyStrategy {
    override fun getAttackProperty(weapon: AttackDecorator, powerUp: AttackDecorator): AttackProperty {
        return if (powerUp.attackType == AttackDecorator.AttackType.PROJECTILE) (weapon.getAttackProperty() + powerUp.getAttackProperty())
        else
            weapon.getAttackProperty()
    }
}

class GetNonProjectileAttackPropertyStrategy : GetAttackPropertyStrategy {
    override fun getAttackProperty(weapon: AttackDecorator, powerUp: AttackDecorator): AttackProperty {
        return if (powerUp.attackType == AttackDecorator.AttackType.NON_PROJECTILE) (weapon.getAttackProperty() + powerUp.getAttackProperty())
        else
            weapon.getAttackProperty()
    }
}
