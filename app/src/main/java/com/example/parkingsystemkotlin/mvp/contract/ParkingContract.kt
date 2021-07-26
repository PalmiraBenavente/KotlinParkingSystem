package com.example.parkingsystemkotlin.mvp.contract

interface ParkingContract {
    interface MainActivityModel {
        fun setParkingSpace(spaces: Int)
        fun getParkingSpace(): Int
    }

    interface MainActivityView {
        fun showSelectionParkingSpaces()
        fun toastShowSpaces(spaces: Int)
        fun showBookParkingPickers()
    }

    interface MainActivityPresenter {
        fun onSelectParkingButtonPressed()
        fun onSetParkingButtonPressed(spaces: Int)
        fun onBookParkingSpaces()
    }
}
