package com.example.parkingsystemkotlin.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.parkingsystemkotlin.databinding.FragmentDialogSpaceParkingBinding
import com.example.parkingsystemkotlin.listener.ListenerDialogFragment
import com.example.parkingsystemkotlin.mvp.contract.DialogSpaceParkingContract
import com.example.parkingsystemkotlin.mvp.presenter.DialogSpaceParkingPresenter
import com.example.parkingsystemkotlin.mvp.view.DialogSpaceParkingView
import com.example.parkingsystemkotlin.utils.Constant

class SpacesParkingDialogFragment : DialogFragment() {
    private lateinit var presenter: DialogSpaceParkingContract.DialogSpaceParkingPresenter
    private lateinit var binding: FragmentDialogSpaceParkingBinding
    private lateinit var inputSpaceListener: ListenerDialogFragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            inputSpaceListener = activity as ListenerDialogFragment
        } catch (e: ClassCastException) {
            Log.e(Constant.CONFIGURE_PARKING_DIALOG_TAG, e.javaClass.canonicalName + e.message)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDialogSpaceParkingBinding.inflate(layoutInflater)
        presenter = DialogSpaceParkingPresenter(view = DialogSpaceParkingView(this, binding))
        setListener()
        return binding.root
    }

    private fun setListener() {
        binding.buttonDialogFragmentOk.setOnClickListener { presenter.onSaveButtonPressed(inputSpaceListener) }
    }
}
