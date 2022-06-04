package decorator.weapon

abstract class Weapon {
    abstract var damage:Int
    abstract var range:Int
    abstract var duration:Int
    abstract var cooltime:Int
    abstract var isProjectileCount:Boolean
}