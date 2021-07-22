package com.example.parkingsystemkotlin.mvp.view

import androidx.fragment.app.DialogFragment
import com.example.parkingsystemkotlin.databinding.FragmentDialogSpaceParkingBinding
import com.example.parkingsystemkotlin.fragments.SpacesParkingDialogFragment
import com.example.parkingsystemkotlin.mvp.contract.DialogSpaceParkingContract
import com.example.parkingsystemkotlin.mvp.view.base.FragmentView

class DialogSpaceParkingView(
    fragment: DialogFragment,
    private val binding: FragmentDialogSpaceParkingBinding
) : FragmentView(fragment), DialogSpaceParkingContract.DialogSpaceParkingView {

    override fun getSpacesFromEditText(): String =
        binding.editTextDialogFragmentSpaces.text.toString()

    override fun dismissDialogFragment() {
        (fragment as SpacesParkingDialogFragment?)?.dismiss()
    }
}
