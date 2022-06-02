package se.gpsapp.gpsappkmm.forms.models

data class FormDataStart(
    override val coordinates: Coordinates = Coordinates(),
) : FormData
