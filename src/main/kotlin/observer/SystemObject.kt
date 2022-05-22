package observer

import jdk.nashorn.internal.parser.DateParser.DAY
import util.toBoolean
import util.toInt

interface SystemObjectDataReceiver {
    fun receiveDayOrNight(dayOrNight:Int)
}

class SystemObject {

    private var gameObjectList = ArrayList<GameObject>()
    private var dayOrNights = DAY

    fun changeDayNight() {
        dayOrNights = (!dayOrNights.toBoolean()).toInt()
    }

    fun registGameObject(gameObject: GameObject) {
        gameObjectList.add(gameObject)
    }

    fun unregistGameObject(gameObject: GameObject) {
        gameObjectList.remove(gameObject)
    }

    fun notifyDayNightChanged(dayOrNight: String){
        gameObjectList.receiveDayOrNight(dayOrNight)
    }
}