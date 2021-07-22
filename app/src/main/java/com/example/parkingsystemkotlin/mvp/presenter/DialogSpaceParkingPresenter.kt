package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.listener.ListenerDialogFragment
import com.example.parkingsystemkotlin.mvp.contract.DialogSpaceParkingContract

class DialogSpaceParkingPresenter(private val view: DialogSpaceParkingContract.DialogSpaceParkingView) :
    DialogSpaceParkingContract.DialogSpaceParkingPresenter {

    override fun onSaveButtonPressed(inputSpaceListener: ListenerDialogFragment) {
        val number: Int = Integer.valueOf(view.getSpacesFromEditText())
        inputSpaceListener.setAmountParkingSpaces(number);
        view.dismissDialogFragment()
    }
}
