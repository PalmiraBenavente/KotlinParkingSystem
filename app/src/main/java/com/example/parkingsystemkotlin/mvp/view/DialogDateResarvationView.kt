package com.example.parkingsystemkotlin.mvp.view

import androidx.fragment.app.DialogFragment
import com.example.parkingsystemkotlin.databinding.FragmentDialogDatePickerBinding
import com.example.parkingsystemkotlin.listener.ListenerDialogFragmentDate
import com.example.parkingsystemkotlin.mvp.contract.DialogDateReservationContract
import com.example.parkingsystemkotlin.mvp.view.base.FragmentView
import java.util.Calendar

class DialogDateResarvationView(
    fragment: DialogFragment,
    private val binding: FragmentDialogDatePickerBinding
) : FragmentView(fragment), DialogDateReservationContract.DialogFragmentDateReservationView {

    override fun dismissPicker() {
        (fragment as DialogFragment).dismiss()
    }

    override fun setDateTime(listenerDate: ListenerDialogFragmentDate, startDatePicker: Boolean, calendar: Calendar) {
        listenerDate.setDateTime(calendar, startDatePicker)
    }

    override fun getYear()  = binding.datePickerDialogFragment.year

    override fun getMonth() = binding.datePickerDialogFragment.month

    override fun getDay() = binding.datePickerDialogFragment.dayOfMonth

    override fun getHour() = binding.timePickerDialogFragment.hour

    override fun getMinute() = binding.timePickerDialogFragment.minute
}
