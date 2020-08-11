package drink.roulette.model.event

class Event(code: EventCode, type: EventType) {
    private var mCode = code
    private var mType = type

    fun getEventCode(): EventCode {
        return mCode
    }

    fun getEventType(): EventType {
        return mType
    }


}





