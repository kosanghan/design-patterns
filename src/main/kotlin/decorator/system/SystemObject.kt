package decorator.system

import decorator.GameObject
import util.DayNight
import java.time.LocalDateTime

interface SystemObjectDataReceiver {
    fun receiveDayOrNight(dayOrNight: DayNight)
}

class SystemObject {

    private var gameObjectList = ArrayList<GameObject>()
    private var dayOrNight: DayNight

    init {
        dayOrNight = if (LocalDateTime.now().hour < 12) DayNight.DAY else DayNight.NIGHT
    }

    fun changeDayNight() {
        dayOrNight = if (dayOrNight == DayNight.DAY) DayNight.NIGHT else DayNight.DAY
        println("$dayOrNight has come")
        notifyDayNightChanged()
    }

    fun registGameObject(gameObject: GameObject) {
        gameObjectList.add(gameObject)
        notifyDayNightChanged()
    }

    fun unregistGameObject(gameObject: GameObject) {
        gameObjectList.remove(gameObject)
    }

    private fun notifyDayNightChanged() {
        gameObjectList.forEach {
            it.performSystemDataReceive(dayOrNight)
        }
    }
}