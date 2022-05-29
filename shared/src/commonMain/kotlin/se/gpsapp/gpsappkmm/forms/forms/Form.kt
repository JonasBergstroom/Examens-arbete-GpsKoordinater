package se.gpsappkmm.gpsappkmm.forms.forms

import se.gpsappkmm.gpsappkmm.forms.components.FormScreen

interface Form {
    val screens: List<FormScreen>
    val type: FormType
}

enum class FormType {
    Start,
}