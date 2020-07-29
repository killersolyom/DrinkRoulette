package drink.roulette.model.questions

import drink.roulette.model.BaseItem

abstract class BaseDefaultQuestion : BaseItem {

    private var mId: Int = -1
    protected var mDescription: String = ""

    constructor(id: Int, description: String) : super() {
        this.mId = id
        mDescription = description
    }

    fun setDescription(description: String) {
        mDescription = description;
    }

    fun getId(): Int {
        return mId
    }

}