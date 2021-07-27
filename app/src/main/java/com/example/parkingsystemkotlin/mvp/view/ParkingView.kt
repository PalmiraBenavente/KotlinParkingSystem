package com.example.parkingsystemkotlin.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.parkingsystemkotlin.R
import com.example.parkingsystemkotlin.activities.ParkingReservationActivity
import com.example.parkingsystemkotlin.databinding.ActivityMainBinding
import com.example.parkingsystemkotlin.fragments.SpacesParkingDialogFragment
import com.example.parkingsystemkotlin.mvp.contract.ParkingContract
import com.example.parkingsystemkotlin.mvp.view.base.ActivityView
import com.example.parkingsystemkotlin.utils.Constant

class ParkingView(activity: Activity, private val binding: ActivityMainBinding) :
    ActivityView(activity = activity), ParkingContract.MainActivityView {

    override fun showSelectionParkingSpaces() {
        SpacesParkingDialogFragment().show(
            fragmentManager,
            Constant.PARKING_DIALOG_TAG
        )
    }

    override fun toastShowSpaces(spaces: Int) {
        activity?.let {
            Toast.makeText(
                it,
                it.getString(R.string.toast_main_activity_select_space_parking, spaces),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun showBookParkingPickers() {
        activity?.let {
            it.startActivity(ParkingReservationActivity.getIntent(it))
        }
    }
}
