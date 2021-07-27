package com.example.parkingsystemkotlin.mvp.contract

interface ReservationParkingContract {

    interface ReservationActivityPresenter {
        fun onButtonStartDatePressedSelectReserver()
        fun onButtonEndDatePressedSelectReserver()
        fun onButtonPressedSaveReserver()
    }

    interface ReservationActivityView {
        fun showDialogDataPiker(startDatePiker: Boolean)
        fun returnToMainActivity()
    }
}
