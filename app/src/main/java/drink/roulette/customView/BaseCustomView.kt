package drink.roulette.customView

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import butterknife.ButterKnife


abstract class BaseCustomView<Item>(context: Context, attrs: AttributeSet?) :
    ConstraintLayout(context, attrs) {
    private lateinit var itemView: View

    private fun inflateView(context: Context) {
        itemView = LayoutInflater.from(context).inflate(getLayoutId(), this, true);
    }

    protected abstract fun getLayoutId(): Int

    private fun initView() {
        ButterKnife.bind(this, itemView)
    }

    protected abstract fun onInitializationFinished()

    fun bindItem(item: Item, layoutParams: ViewGroup.LayoutParams?) {}

    fun bindItem(item: Item) {}

    fun unbind() {}

    init {
        inflateView(context)
        initView()
        onInitializationFinished()
    }
}