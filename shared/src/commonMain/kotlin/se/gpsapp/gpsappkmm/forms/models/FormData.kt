package se.gpsapp.gpsappkmm.forms.models


interface FormData {
    val coordinates: Coordinates
}

data class Coordinates(
    var longitude: Double? = null,
    var latitude: Double? = null,
)
