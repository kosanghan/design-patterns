package observer

import util.DayNight
import java.time.LocalDateTime

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

    fun registerGameObject(gameObject: GameObject) {
        gameObjectList.add(gameObject)
        notifyDayNightChanged()
    }

    fun unregisterGameObject(gameObject: GameObject) {
        gameObjectList.remove(gameObject)
    }

    private fun notifyDayNightChanged() {
        gameObjectList.forEach {
            it.performSystemDataReceive(dayOrNight)
        }
    }
}