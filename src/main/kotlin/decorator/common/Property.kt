package decorator.common

data class AttackProperty(
    var damage: Int,
    var range: Int,
    var duration: Int,
    var cooltime: Int,
    var projectileCount: Int,
    var projectileSpeed: Int
) {
    operator fun plus(attackProperty: AttackProperty): AttackProperty {
        return AttackProperty(
            this.damage + attackProperty.damage,
            this.range + attackProperty.range,
            this.duration + attackProperty.duration,
            this.cooltime + attackProperty.cooltime,
            this.projectileCount + attackProperty.projectileCount,
            this.projectileSpeed + attackProperty.projectileSpeed
        )
    }
}