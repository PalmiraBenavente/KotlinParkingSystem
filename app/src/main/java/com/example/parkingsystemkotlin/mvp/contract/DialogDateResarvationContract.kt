package com.example.parkingsystemkotlin.mvp.contract

interface DialogDateResarvationContract {

    interface DialogFragmentDateReservationPresenter {
        fun onOkButtonPressed()
        fun onCancelButtonPressed()
    }

    interface DialogFragmentDateReservationView {
        fun dismissPicker()
    }
}
