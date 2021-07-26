package com.example.parkingsystemkotlin.mvp.view

import android.app.Activity
import com.example.parkingsystemkotlin.databinding.ActivityReserverParkingLotBinding
import com.example.parkingsystemkotlin.fragments.DateReservationDialogFragment
import com.example.parkingsystemkotlin.mvp.contract.ReservationParkingContract
import com.example.parkingsystemkotlin.mvp.view.base.ActivityView
import com.example.parkingsystemkotlin.utils.Constant

class ReservationParkingView(activity: Activity, binding: ActivityReserverParkingLotBinding) :
    ActivityView(activity), ReservationParkingContract.ReservationActivityView {

    override fun showDialogDataPiker(startDatePiker: Boolean) {
        val dateDialogFragment = DateReservationDialogFragment.newInstance(startDatePiker)
        dateDialogFragment.show(
            fragmentManager,
            Constant.DIALOG_FRAGMENT_DATE_PICKER
        )
    }

    override fun returnToMainActivity() {
        activity?.finish()
    }
}
