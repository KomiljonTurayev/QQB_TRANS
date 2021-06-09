package uz.uzsoft.qqbtrans.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.uzsoft.qqbtrans.R
import uz.uzsoft.qqbtrans.databinding.FragmentLoginBinding
//import uz.uzsoft.qqbtrans.databinding.LoginFragmentBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registration.setOnClickListener {
            findNavController().navigate(R.id.nav_registration)
        }

    }


}