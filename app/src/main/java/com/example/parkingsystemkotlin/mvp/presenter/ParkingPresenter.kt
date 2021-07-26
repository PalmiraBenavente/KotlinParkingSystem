package com.example.parkingsystemkotlin.mvp.presenter

import com.example.parkingsystemkotlin.mvp.contract.ParkingContract

class ParkingPresenter(
    private val model: ParkingContract.MainActivityModel,
    private val view: ParkingContract.MainActivityView
) : ParkingContract.MainActivityPresenter {

    override fun onSelectParkingButtonPressed() {
        view.showSelectionParkingSpaces()
    }

    override fun onSetParkingButtonPressed(spaces: Int) {
        model.setParkingSpace(spaces)
        view.toastShowSpaces(model.getParkingSpace())
    }

    override fun onBookParkingSpaces() {
        view.showBookParkingPickers()
    }
}
