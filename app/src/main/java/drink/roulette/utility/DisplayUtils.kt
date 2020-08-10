package drink.roulette.utility

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.concurrent.ThreadLocalRandom

class DisplayUtils {
    internal companion object {
        @JvmStatic

        fun setRandomLayoutHeight(view: View) {
            val number = ThreadLocalRandom.current().nextDouble(0.3, 1.0).toFloat()
            setLayoutHeight(view, number)
        }

        fun setLayoutHeight(view: View, height: Float) {
            val layoutParams = (view.layoutParams as ConstraintLayout.LayoutParams)
            layoutParams.matchConstraintPercentHeight = height
            view.layoutParams = layoutParams
            view.invalidate()
        }

    }
}