package se.gpsappkmm.gpsappkmm.android

import android.app.Application
import se.gpsapp.gpsappkmm.forms.models.FormViewModel
import se.gpsappkmm.gpsappkmm.forms.forms.FormType

class MainApplication : Application() {
    var formViewModel: FormViewModel =
        FormViewModel(FormStart(FormType.Start))

    fun setViewModel(formType: FormType) {
        formViewModel = when (formType) {
            FormType.Start -> FormViewModel(FormStart(FormType.Start))
        }
    }
}