package se.gpsappkmm.gpsappkmm.android.ui.newtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import se.gpsappkmm.gpsappkmm.android.MainApplication
import se.gpsappkmm.gpsappkmm.android.R
import se.gpsappkmm.gpsappkmm.android.databinding.FragmentStartMenuBinding
import se.gpsappkmm.gpsappkmm.forms.forms.FormType

class StartMenuFragment : Fragment() {

    private var fragmentStartMenuBinding: FragmentStartMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start_menu, container, false)
        val binding = FragmentStartMenuBinding.bind(view)
        val application = (activity?.application as MainApplication)

        binding.gobackBtn.setOnClickListener {
            view.findNavController().navigateUp()
        }
        binding.startContainer.setOnClickListener {
            application.setViewModel(formType = FormType.Start)
            view.findNavController().navigate(R.id.navigateToFormFragment)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentStartMenuBinding = null
    }
}