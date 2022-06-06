package decorator.weapon

import decorator.common.AttackProperty

class Knife : BaseWeapon() {
    override var baseWeaponAttackProperty = AttackProperty(10, 50, 50, 10, 2, 50)

    init {
        setAttackStrategy(ProjectileAttackStrategy())
    }
}

class Garlic : BaseWeapon() {
    override var baseWeaponAttackProperty = AttackProperty(5, 50, 50, 10, 0, 0)

    init {
        setAttackStrategy(NonProjectileAttackStrategy())
    }
}