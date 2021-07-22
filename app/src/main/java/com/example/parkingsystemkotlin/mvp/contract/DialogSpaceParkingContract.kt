package com.example.parkingsystemkotlin.mvp.contract

import com.example.parkingsystemkotlin.listener.ListenerDialogFragment

interface DialogSpaceParkingContract {

    interface DialogSpaceParkingPresenter {
        fun onSaveButtonPressed(inputSpaceListener: ListenerDialogFragment)
    }

    interface DialogSpaceParkingView {
        fun getSpacesFromEditText(): String
        fun dismissDialogFragment()
    }
}
