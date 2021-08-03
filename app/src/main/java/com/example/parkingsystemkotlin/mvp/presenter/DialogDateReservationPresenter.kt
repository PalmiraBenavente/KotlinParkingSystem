package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.listener.ListenerDialogFragmentDate
import com.example.parkingsystemkotlin.mvp.contract.DialogDateReservationContract
import com.example.parkingsystemkotlin.utils.Constant
import java.util.*

class DialogDateReservationPresenter(
    private val view: DialogDateReservationContract.DialogFragmentDateReservationView,
    private val startDatePicker: Boolean
) : DialogDateReservationContract.DialogFragmentDateReservationPresenter {

    override fun onOkButtonPressed(listenerDate: ListenerDialogFragmentDate) {
        val calendar = Calendar.getInstance().apply {
            set(view.getYear(), view.getMonth(), view.getDay(), view.getHour(), view.getMinute())
            set(Calendar.SECOND, ZERO)
            set(Calendar.MILLISECOND, ZERO)
        }
        view.setDateTime(listenerDate, startDatePicker, calendar)
        view.dismissPicker()
    }

    override fun onCancelButtonPressed() {
        view.dismissPicker()
    }

    companion object {
        private const val ZERO = 0
    }
}
