package decorator.weapon

import decorator.common.AttackProperty

abstract class BasePowerUp : AttackDecorator() {
    private var baseWeapon: BaseWeapon? = null
    fun setBaseWeapon(baseWeapon: BaseWeapon) {
        this.baseWeapon = baseWeapon
        attackPropertyStrategy = getAttackPropertyStrategy(baseWeapon)
    }

    abstract var basePowerUpAttackProperty: AttackProperty
    private lateinit var attackPropertyStrategy: GetAttackPropertyStrategy

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
        TODO("Not yet implemented")
    }
}

class GetNonProjectileAttackPropertyStrategy : GetAttackPropertyStrategy {
    override fun getAttackProperty(weapon: AttackDecorator, powerUp: AttackDecorator): AttackProperty {
        TODO("Not yet implemented")
    }
}