package drink.roulette.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout


abstract class BaseCustomView<Item>(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs) {
    private lateinit var mItemView: View

    private fun inflateView(context: Context) {
        mItemView = LayoutInflater.from(context).inflate(getLayoutId(), this, true)
    }

    protected abstract fun getLayoutId(): Int

    private fun initView() {
        findView(mItemView)
    }

    protected abstract fun findView(view: View)

    protected abstract fun onInitializationFinished()

    protected abstract fun onDestroy()

    fun bindItem(item: Item, layoutParams: ViewGroup.LayoutParams?) {}

    fun bindItem(item: Item) {}

    fun unbind() {}

    init {
        inflateView(context)
        initView()
        onInitializationFinished()
    }
}