package se.gpsappkmm.gpsappkmm.android

import android.app.Application
import se.gpsapp.gpsappkmm.forms.forms.FormInfiltrations
import se.gpsappkmm.gpsappkmm.forms.forms.FormType

class MainApplication : Application() {
    var formViewModel: FormViewModel =
        FormViewModel(FormInfiltrations(FormType.Infiltration))

    fun setViewModel(formType: FormType) {
        formViewModel = when (formType) {
            FormType.Infiltration -> FormViewModel(FormInfiltrations(FormType.Infiltration))
        }
    }
}