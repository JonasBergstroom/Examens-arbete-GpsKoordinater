package se.gpsapp.gpsappkmm.forms.models

import se.gpsappkmm.gpsappkmm.forms.components.*
import se.gpsappkmm.gpsappkmm.forms.forms.Form
import se.gpsappkmm.gpsappkmm.utilities.ViewModelState
import se.gpsappkmm.gpsappkmm.utilities.ViewModelStateImpl

class FormViewModel constructor(
    val form: Form
) : ViewModelState<FormViewModel.State> by ViewModelStateImpl(State(form)) {
    fun nextScreen() {
        if (state.value.currentScreen < state.value.form.screens.size - 1) {
            updateStateAndSave {
                copy(currentScreen = currentScreen + 1)
            }
        }
    }

    fun setCoordinates(latitude: Double, longitude: Double) =
        state.value.components.firstOrNull {
            it is FormComponentMap
        }.let {
            updateStateAndSave {
                form.setCoordinates(latitude, longitude, state.value)
                    .copy(counter = counter + 1)
            }
        }

    fun previousScreen() {
        if (state.value.currentScreen > 0) {
            updateStateAndSave {
                copy(currentScreen = currentScreen - 1)
            }
        }
    }

    private fun updateStateAndSave(state: State.() -> State) {
        updateState(state).also(::save)
    }

    private fun save(state: State) {
        println("Saving state: $state")
    }

    data class State(
        val form: Form,
        val currentScreen: Int = 0,
        val counter: Int = 0,
    ) {
        val components: List<FormComponent> = form.screens[currentScreen].components
        val totalScreens: Int = form.screens.size
    }
}