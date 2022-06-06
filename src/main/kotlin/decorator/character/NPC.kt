package decorator.character

import observer.SystemObject
import observer.SystemObjectDataReceiverPull
import util.DayNight

class VampireNPC() : observer.GameObject(), SystemObjectDataReceiverPull {

    private lateinit var systemObject: SystemObject

    constructor(systemObject: SystemObject) : this() {
        this.systemObject = systemObject
    }

    init {
        setSystemObjectDataReceiverPull(this)
    }

    override fun receiveDayOrNight() {
        setInterfaceStrategy(if (systemObject.getDayOrNight() == DayNight.DAY) observer.TalkInteractStrategy() else observer.AttackInteractStrategy())
    }
}

class OtherNPC : observer.GameObject()