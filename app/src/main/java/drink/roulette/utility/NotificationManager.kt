package drink.roulette.utility

import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import drink.roulette.R
import drink.roulette.activity.BaseActivity


class NotificationManager(baseActivity: BaseActivity) {

    private var mView: View = baseActivity.getView()
    private var mDefaultColor = baseActivity.getColor(R.color.colorDarkGreen)
    private var mErrorColor = baseActivity.getColor(R.color.colorRed)

    fun showSnackBar(message: String, isError: Boolean) {
        Snackbar
            .make(mView, message, Snackbar.LENGTH_INDEFINITE)
            .setBackgroundTint(if (isError) mErrorColor else mDefaultColor)
            .setDuration(3000)
            .show()
    }

    fun showSnackBar(textId: Int, isError: Boolean) {
        showSnackBar(mView.context.getString(textId), isError)
    }

    fun showToast(message: String, longDuration: Boolean) {
        Toast.makeText(
            mView.context, message, if (longDuration) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        ).show()
    }

    fun showToast(textId: Int, longDuration: Boolean) {
        showToast(mView.context.getString(textId), longDuration)
    }

}