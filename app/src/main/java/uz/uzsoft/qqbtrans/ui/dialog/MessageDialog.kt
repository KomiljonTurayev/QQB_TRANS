package uz.uzsoft.qqbtrans.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import uz.uzsoft.qqbtrans.R


class MessageDialog(context: Context, private val pos: Int, private val message: String) :
    AlertDialog(context) {
    private val contentView =
        LayoutInflater.from(context).inflate(R.layout.dialog_message, null, false)

    init {
        setView(contentView)
        when (pos) {
            0 -> {
                contentView.title.text = "Error!"
                contentView.image.setBackgroundResource(R.drawable.wrong)
            }
            1 -> {
                contentView.title.text = "Success!"
               contentView.image.setBackgroundResource(R.drawable.correct)
            }
            2 -> {
                contentView.title.text = "Congratulation!"
                contentView.title.textSize=18F
                contentView.image.setBackgroundResource(R.drawable.congratulation)
            }
        }
        contentView.message.text = message

    }

}