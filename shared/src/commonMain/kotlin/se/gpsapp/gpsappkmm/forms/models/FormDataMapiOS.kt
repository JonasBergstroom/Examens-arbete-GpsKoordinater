package se.gpsapp.gpsappkmm.forms.models

data class FormDataMapiOS(
    override val coordinates: Coordinates = Coordinates(),
) : FormData
