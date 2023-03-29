package com.example.bmi_mui


import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class Observable : BaseObservable() {
    @get:Bindable

    var height: String=  " "
        set(value) {
            field = value
            notifyPropertyChanged(BR.height)
        }

    @get:Bindable

    var weight : String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.weight)

        }
}