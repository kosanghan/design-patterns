package decorator.character

import decorator.AttackInteractStrategy
import decorator.GameObject
import decorator.TalkInteractStrategy
import decorator.system.SystemObjectDataReceiver
import util.DayNight

class VampireNPC : GameObject(), SystemObjectDataReceiver {
    init {
        setSystemObjectDataReceiver(this)
    }

    override fun receiveDayOrNight(dayOrNight: DayNight) {
        setInterfaceStrategy(if (dayOrNight == DayNight.DAY) TalkInteractStrategy() else AttackInteractStrategy())
    }
}

class OtherNPC : GameObject() {

}