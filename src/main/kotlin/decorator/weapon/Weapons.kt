package decorator.weapon

class Knife : BaseWeapon() {
    override var baseWeaponProperty = BaseWeaponProperty(10, 50, 50, 10, 2, 50)

    init {
        setAttackStrategy(ProjectileAttackStrategy())
    }
}

class Garlic : BaseWeapon() {
    override var baseWeaponProperty = BaseWeaponProperty(5, 50, 50, 10, 0, 0)

    init {
        setAttackStrategy(NonProjectileAttackStrategy())
    }
}