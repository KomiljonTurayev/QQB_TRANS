package uz.uzsoft.qqbtrans.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import uz.uzsoft.qqbtrans.R
import uz.uzsoft.qqbtrans.databinding.DialogMessageBinding

//import uz.uzsoft.qqbtrans.databinding.DialogMessageBinding


class MessageDialog(context: Context, pos: Int, message: String) :
    AlertDialog(context) {
    private val binding= DialogMessageBinding.inflate(LayoutInflater.from(context), null,false)

    init {
        setView(binding.root)
        when (pos) {
            0 -> {
                binding.title.text = "Error!"
                binding.image.setBackgroundResource(R.drawable.wrong)
            }
            1 -> {
                binding.title.text = "Success!"
               binding.image.setBackgroundResource(R.drawable.correct)
            }
            2 -> {
                binding.title.text = "Congratulation!"
                binding.title.textSize=18F
                binding.image.setBackgroundResource(R.drawable.congratulation)
            }
        }
        binding.message.text = message
    }

}