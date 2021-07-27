package com.example.parkingsystemkotlin.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.parkingsystemkotlin.databinding.ActivityMainBinding
import com.example.parkingsystemkotlin.listener.ListenerDialogFragment
import com.example.parkingsystemkotlin.mvp.contract.ParkingContract
import com.example.parkingsystemkotlin.mvp.model.ParkingModel
import com.example.parkingsystemkotlin.mvp.presenter.ParkingPresenter
import com.example.parkingsystemkotlin.mvp.view.ParkingView

class ParkingActivity : AppCompatActivity(), ListenerDialogFragment {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: ParkingContract.MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = ParkingPresenter(model = ParkingModel(), view = ParkingView(this, binding))
        setListeners()
    }

    private fun setListeners() {
        binding.buttonMainSelectParking.setOnClickListener { presenter.onSelectParkingButtonPressed() }
        binding.buttonMainBookParkingSpaces.setOnClickListener { presenter.onBookParkingSpaces() }
    }

    override fun setAmountParkingSpaces(spaces: Int) {
        presenter.onSetParkingButtonPressed(spaces)
    }
}
