package Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bmi_mui.BmiViewModel


class ViewModelFactory(private  var BMI: Double) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BmiViewModel::class.java)){
            return BmiViewModel(BMI) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class") // ye code chal raha hi
    }
}
