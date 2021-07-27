package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.mvp.contract.ReservationParkingContract

class ReservationParkingPresenter(private val view: ReservationParkingContract.ReservationActivityView) :
    ReservationParkingContract.ReservationActivityPresenter {

    override fun onButtonStartDatePressedSelectReserver() {
        view.showDialogDataPiker(true)
    }

    override fun onButtonEndDatePressedSelectReserver() {
        view.showDialogDataPiker(false)
    }

    override fun onButtonPressedSaveReserver() {
        view.returnToMainActivity()
    }
}
