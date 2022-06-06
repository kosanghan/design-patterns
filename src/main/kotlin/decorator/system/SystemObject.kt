package decorator.system

import decorator.GameObject
import util.DayNight
import java.time.LocalDateTime

interface Subject<T> {
    var observerList: ArrayList<T>
    fun registerObserver(observer: T)
    fun removeObserver(observer: T)
    fun notifyObserver()
}

open class GameObjectSubject : Subject<GameObject> {

    override var observerList = ArrayList<GameObject>()

    override fun registerObserver(observer: GameObject) {
        observerList.add(observer)
        notifyObserver()
    }

    override fun removeObserver(observer: GameObject) {
        observerList.remove(observer)
    }

    override fun notifyObserver() {
        observerList.forEach {
            it.performSystemDataReceive()
        }
    }
}

class SystemObject : GameObjectSubject() {
    private var dayOrNight: DayNight

    init {
        dayOrNight = if (LocalDateTime.now().hour < 12) DayNight.DAY else DayNight.NIGHT
    }

    fun changeDayNight() {
        dayOrNight = if (dayOrNight == DayNight.DAY) DayNight.NIGHT else DayNight.DAY
        println("$dayOrNight has come")
        notifyObserver()
    }

    fun getDayOrNight(): DayNight {
        return dayOrNight
    }
}