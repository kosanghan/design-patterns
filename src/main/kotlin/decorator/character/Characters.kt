package decorator.character

import decorator.SystemObjectDataReceiverPull
import decorator.common.AttackProperty
import decorator.system.SystemObject
import util.DayNight

class NormalBaseCharacter() : BaseCharacter() {
    var characterAttackProperty = AttackProperty(0, 0, 0, 0, 0, 0)
    private lateinit var systemObject: SystemObject

    constructor(systemObject: SystemObject) : this() {
        this.systemObject = systemObject
    }

    init {
        showCharacterInfo("${this.javaClass.simpleName} created")
    }

    override fun getAttackProperty(): AttackProperty {
        return characterAttackProperty
    }
}

class VampireBaseCharacter() : BaseCharacter(), SystemObjectDataReceiverPull {
    var characterAttackProperty = AttackProperty(10, 10, 10, 10, 10, 10)
    private lateinit var systemObject: SystemObject

    constructor(systemObject: SystemObject) : this() {
        this.systemObject = systemObject
    }

    init {
        showCharacterInfo("${this.javaClass.simpleName} created")
        setSystemObjectDataReceiver(this)
    }

    override fun receiveDayOrNight() {
        characterAttackProperty = if (systemObject.getDayOrNight() == DayNight.DAY) {
            println("Vampire has been weak")
            AttackProperty(0, 0, 0, 0, 0, 0)
        } else {
            println("Vampire has been strong")
            AttackProperty(10, 10, 10, 10, 10, 10)
        }
    }

    override fun getAttackProperty(): AttackProperty {
        return characterAttackProperty
    }
}