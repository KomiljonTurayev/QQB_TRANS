package uz.uzsoft.qqbtrans.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.pinball83.maskededittext.MaskedEditText
import uz.uzsoft.qqbtrans.R
import uz.uzsoft.qqbtrans.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val binding by viewBinding(FragmentRegistrationBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        val btnReg = view.findViewById<Button>(R.id.btnReg)
//        val phone_number = view.findViewById<MaskedEditText>(R.id.phone_number)

               
        binding.btnReg.setOnClickListener {

            Log.d("TTT", "${ binding.phoneNumber.text}")

            if ( binding.phoneNumber.textSize > 10) {
                Log.d("TTT", "${ binding.phoneNumber.text} _2")

            }
        }

    }
}