package decorator.weapon

import decorator.GameObjectData
import decorator.GameObjectType
import decorator.common.AttackProperty

class Knife : BaseWeapon() {
    override var gameObjectData: GameObjectData = GameObjectData(GameObjectType.WEAPON)
    
    override var baseWeaponAttackProperty = AttackProperty(10, 50, 50, 10, 2, 50)
    override var attackType = AttackType.PROJECTILE

    init {
        description = "KNIFE"
        setAttackStrategy(ProjectileAttackStrategy())
    }

    override fun getAttackProperty(): AttackProperty {
        return baseWeaponAttackProperty
    }
}

class Garlic : BaseWeapon() {
    override var gameObjectData: GameObjectData = GameObjectData(GameObjectType.WEAPON)

    override var baseWeaponAttackProperty = AttackProperty(5, 50, 50, 10, 0, 0)
    override var attackType = AttackType.NON_PROJECTILE

    init {
        description = "GARLIC"
        setAttackStrategy(NonProjectileAttackStrategy())
    }

    override fun getAttackProperty(): AttackProperty {
        return baseWeaponAttackProperty
    }
}