package com.example.parkingsystemkotlin.mvp.view

import androidx.fragment.app.DialogFragment
import com.example.parkingsystemkotlin.mvp.contract.DialogDateResarvationContract
import com.example.parkingsystemkotlin.mvp.view.base.FragmentView

class DialogDateResarvationView(
    fragment: DialogFragment,
) : FragmentView(fragment), DialogDateResarvationContract.DialogFragmentDateReservationView {

    override fun dismissPicker() {
        (fragment as DialogFragment).dismiss()
    }
}
