package uz.uzsoft.qqbtrans.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.github.pinball83.maskededittext.MaskedEditText
import uz.uzsoft.qqbtrans.R

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnReg = view.findViewById<Button>(R.id.btnReg)
        val phone_number = view.findViewById<MaskedEditText>(R.id.phone_number)

        btnReg.setOnClickListener {

            Log.d("TTT", "${phone_number.text}")

            if (phone_number.textSize > 10) {
                Log.d("TTT", "${phone_number.text} _2")

            }
        }

    }
}