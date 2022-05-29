package se.gpsappkmm.gpsappkmm.android.ui.form

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import se.gpsappkmm.gpsappkmm.android.MainApplication
import se.gpsappkmm.gpsappkmm.android.R
import se.gpsappkmm.gpsappkmm.android.databinding.FragmentFormBinding
import se.gpsappkmm.gpsappkmm.android.forms.AndroidFormGenerator
import se.gpsapp.gpsappkmm.forms.models.FormViewModel
import se.gpsappkmm.gpsappkmm.forms.components.FormComponent

class FormFragment : Fragment() {
    private var binding: FragmentFormBinding? = null
    private var formGenerator: AndroidFormGenerator? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.formGenerator = AndroidFormGenerator(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form, container, false)
        binding = FragmentFormBinding.bind(view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = (activity?.application as MainApplication)
        val viewModel = application.formViewModel

        lifecycleScope.launchWhenStarted {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect(::updateView)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

    private fun updateView(state: FormViewModel.State) {
        println("StateJV: $state")

        displayComponents(state.components, state.currentScreen)
    }

    private fun displayComponents(components: List<FormComponent>, currentScreen: Int) {
        if (binding?.scrollView?.childCount == 0) {
            binding?.scrollView?.addView(formGenerator?.createInterface(components))
        } else {
            formGenerator?.updateInterface(components, currentScreen)
        }
    }
}