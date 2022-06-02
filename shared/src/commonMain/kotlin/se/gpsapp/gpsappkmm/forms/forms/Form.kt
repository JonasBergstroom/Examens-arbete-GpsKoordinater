package se.gpsappkmm.gpsappkmm.forms.forms

import se.gpsapp.gpsappkmm.forms.models.FormData
import se.gpsapp.gpsappkmm.forms.models.FormViewModel
import se.gpsappkmm.gpsappkmm.forms.components.FormScreen

interface Form {
    val screens: List<FormScreen>
    val type: FormType
    val data: FormData

    fun setCoordinates(
        latitude: Double,
        longitude: Double,
        state: FormViewModel.State
    ): FormViewModel.State {
        with(state.form.data) {
            this.coordinates.latitude = latitude
            this.coordinates.longitude = longitude
        }
        return state
    }
}


    enum class FormType {
    Start,
}