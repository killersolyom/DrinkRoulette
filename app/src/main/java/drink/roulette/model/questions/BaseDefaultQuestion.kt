package drink.roulette.model.questions

import drink.roulette.model.DefaultItem

abstract class BaseDefaultQuestion(id: Int, description: String) : DefaultItem() {

    private var mId: Int = id
    protected var mDescription: String = description

    fun getId(): Int {
        return mId
    }
}