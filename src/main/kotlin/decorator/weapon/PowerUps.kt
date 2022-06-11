package decorator.weapon

import decorator.GameObjectData
import decorator.GameObjectType
import decorator.common.AttackProperty

class DamageUp : BasePowerUp() {
    override var gameObjectData: GameObjectData = GameObjectData(GameObjectType.POWER_UP)

    override var basePowerUpAttackProperty = AttackProperty(10, 0, 0, 0, 0, 0)
    override var attackType = AttackType.BOTH

    override fun getAttackProperty(): AttackProperty {
        var baseWeapon = getBaseWeapon()
        return if (baseWeapon != null)
            attackPropertyStrategy.getAttackProperty(baseWeapon, this)
        else
            basePowerUpAttackProperty
    }

    init {
        description = "DAMAGE UP "
    }
}