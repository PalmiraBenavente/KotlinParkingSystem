package com.example.parkingsystemkotlin.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.parkingsystemkotlin.databinding.FragmentDialogDatePickerBinding
import com.example.parkingsystemkotlin.listener.ListenerDialogFragmentDate
import com.example.parkingsystemkotlin.mvp.contract.DialogDateReservationContract
import com.example.parkingsystemkotlin.mvp.presenter.DialogDateReservationPresenter
import com.example.parkingsystemkotlin.mvp.view.DialogDateResarvationView
import com.example.parkingsystemkotlin.utils.Constant

class DateReservationDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentDialogDatePickerBinding
    private lateinit var presenter: DialogDateReservationContract.DialogFragmentDateReservationPresenter
    private lateinit var listenerDate: ListenerDialogFragmentDate

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogDatePickerBinding.inflate(layoutInflater)
        arguments?.let {
            presenter = DialogDateReservationPresenter(
                view = DialogDateResarvationView(this, binding),
                it.getBoolean(Constant.TAG_START_DATE)
            )
        }

        setListener()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listenerDate = activity as ListenerDialogFragmentDate
        } catch (e: ClassCastException) {
            Log.e(Constant.TAG_RESERVATION, e.javaClass.canonicalName + e.message)
        }
    }

    private fun setListener() {
        binding.buttonReservationDialogFragmentConfirm.setOnClickListener {
            presenter.onOkButtonPressed(
                listenerDate
            )
        }
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
