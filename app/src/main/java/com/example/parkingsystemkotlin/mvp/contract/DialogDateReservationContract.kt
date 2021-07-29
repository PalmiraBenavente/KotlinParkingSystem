package com.example.parkingsystemkotlin.mvp.contract

import com.example.parkingsystemkotlin.listener.ListenerDialogFragmentDate
import java.util.Calendar

interface DialogDateReservationContract {

    interface DialogFragmentDateReservationPresenter {
        fun onOkButtonPressed(listenerDate: ListenerDialogFragmentDate)
        fun onCancelButtonPressed()
    }

    interface DialogFragmentDateReservationView {
        fun dismissPicker()
        fun setDateTime(listenerDate: ListenerDialogFragmentDate, startDatePicker: Boolean, calendar: Calendar)
        fun getYear(): Int
        fun getMonth(): Int
        fun getDay(): Int
        fun getHour(): Int
        fun getMinute(): Int
    }
}
