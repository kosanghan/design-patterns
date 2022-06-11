package decorator.character

import decorator.GameObjectData
import decorator.GameObjectType
import decorator.SystemObjectDataReceiverPull
import decorator.common.AttackProperty
import decorator.system.SystemObject
import util.DayNight

class NormalCharacter() : BaseCharacter() {

    override var gameObjectData: GameObjectData = GameObjectData(GameObjectType.CHARACTER)

    override var baseCharacterAttackProperty: AttackProperty = AttackProperty(0, 0, 0, 0, 0, 0)
    private lateinit var systemObject: SystemObject

    constructor(systemObject: SystemObject) : this() {
        this.systemObject = systemObject
    }

    init {
    }
}

class VampireCharacter() : BaseCharacter(), SystemObjectDataReceiverPull {

    override var gameObjectData: GameObjectData = GameObjectData(GameObjectType.CHARACTER)

    override var baseCharacterAttackProperty: AttackProperty = AttackProperty(10, 10, 10, 10, 10, 10)
    private lateinit var systemObject: SystemObject

    constructor(systemObject: SystemObject) : this() {
        this.systemObject = systemObject
    }

    init {
        setSystemObjectDataReceiver(this)
    }

    override fun receiveDayOrNight() {
        baseCharacterAttackProperty = if (systemObject.getDayOrNight() == DayNight.DAY) {
            println("Vampire has been weak")
            AttackProperty(0, 0, 0, 0, 0, 0)
        } else {
            println("Vampire has been strong")
            AttackProperty(10, 10, 10, 10, 10, 10)
        }
    }
}