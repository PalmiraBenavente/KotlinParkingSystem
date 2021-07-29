package com.example.parkingsystemkotlin.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.parkingsystemkotlin.R
import com.example.parkingsystemkotlin.databinding.ActivityReserverParkingLotBinding
import com.example.parkingsystemkotlin.fragments.DateReservationDialogFragment
import com.example.parkingsystemkotlin.mvp.contract.ReservationParkingContract
import com.example.parkingsystemkotlin.mvp.view.base.ActivityView
import com.example.parkingsystemkotlin.utils.Constant

class ReservationParkingView(
    activity: Activity,
    private val binding: ActivityReserverParkingLotBinding
) :
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

    override fun getParkingLot(): String {
        return binding.editTextReserverParkingPlace.text.toString()
    }

    override fun getParkingCode(): String {
        return binding.editTextReserverParkingCode.text.toString()
    }

    override fun toastShowFormatError() {
        showToast(R.string.toast_format_erro)
    }

    override fun toastShowMissingDate() {
        showToast(R.string.toast_reservation_missing_date)
    }

    override fun toastShowMissingLot() {
        showToast(R.string.toast_reservation_overlap_missing_lot)
    }

    override fun toastShowMissingCode() {
        showToast(R.string.toast_reservation_missing_code)
    }

    override fun toastShowOverlap() {
        showToast(R.string.toast_reservation_overlap)
    }

    override fun toastShowReserveOK() {
        showToast(R.string.toast_reservation_ok)
    }


    override fun toastShowTextData(lote: Int, code: Int, startDate: String, endDate: String) {
        activity?.let {
            Toast.makeText(
                it,
                it.getString(R.string.toast_resaervation_parking, lote, code, startDate, endDate),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun showToast(messageId: Int) {
        activity?.let {
            Toast.makeText(it, messageId, Toast.LENGTH_SHORT).show()
        }
    }
}
