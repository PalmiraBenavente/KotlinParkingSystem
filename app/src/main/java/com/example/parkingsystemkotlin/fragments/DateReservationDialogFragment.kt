package com.example.parkingsystemkotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.parkingsystemkotlin.databinding.FragmentDialogDatePickerBinding
import com.example.parkingsystemkotlin.mvp.contract.DialogDateResarvationContract
import com.example.parkingsystemkotlin.mvp.presenter.DialogDateResarvationPresenter
import com.example.parkingsystemkotlin.mvp.view.DialogDateResarvationView
import com.example.parkingsystemkotlin.utils.Constant

class DateReservationDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentDialogDatePickerBinding
    private lateinit var presenter: DialogDateResarvationContract.DialogFragmentDateReservationPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentDialogDatePickerBinding.inflate(layoutInflater)
        presenter = DialogDateResarvationPresenter(view = DialogDateResarvationView(this))
        setListener()
        return binding.root
    }

    private fun setListener() {
        binding.buttonReservationDialogFragmentConfirm.setOnClickListener { presenter.onOkButtonPressed() }
        binding.buttonReservationDialogFragmentCancel.setOnClickListener { presenter.onCancelButtonPressed() }
    }

    companion object {
        fun newInstance(isStartDate: Boolean): DateReservationDialogFragment {
            val bundle = Bundle()
            bundle.putBoolean(Constant.TAG_START_DATE, isStartDate)
            val dialog = DateReservationDialogFragment()
            dialog.arguments = bundle
            return dialog
        }
    }
}
