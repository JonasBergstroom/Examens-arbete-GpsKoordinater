package se.gpsapp.gpsappkmm.forms.models

import se.gpsapp.gpsappkmm.forms.forms.FormStart
import se.gpsappkmm.gpsappkmm.forms.forms.Form
import se.gpsappkmm.gpsappkmm.forms.forms.FormType

class FormFactory() {
    fun createForm(type: FormType): Form {
        return when (type) {
            FormType.Start -> FormStart()
        }
    }
}