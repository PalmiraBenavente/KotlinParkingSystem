package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.mvp.contract.DialogDateResarvationContract

class DialogDateResarvationPresenter(
    private val view: DialogDateResarvationContract.DialogFragmentDateReservationView,
) : DialogDateResarvationContract.DialogFragmentDateReservationPresenter {

    override fun onOkButtonPressed() {
        view.dismissPicker()
    }

    override fun onCancelButtonPressed() {
        view.dismissPicker()
    }
}
