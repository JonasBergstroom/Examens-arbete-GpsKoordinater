package se.gpsappkmm.gpsappkmm.forms.components

interface FormGenerator {
    fun generateInterface(components: List<FormComponent>, currentScreen: Int? = null)
}