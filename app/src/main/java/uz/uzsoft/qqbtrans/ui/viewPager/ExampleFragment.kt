package uz.uzsoft.qqbtrans.ui.viewPager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.uzsoft.qqbtrans.R

class ExampleFragment : Fragment(R.layout.intro_page) {

    private var listenerNext: ((Int)->Unit)?=null
    private var listenerBack: ((Int) -> Unit)? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = requireArguments()
        val color=bundle.getInt("COLOR",0)
        image.setImageResource(bundle.getInt("IMAGE",0))
        layoutContent.setBackgroundColor(color)
        infoIntro.text=bundle.getString("INFO","")
        back.setOnClickListener {
            listenerBack?.invoke(color)
        }
        next.setOnClickListener {
            listenerNext?.invoke(color)
        }
    }
    fun setNext(block: (Int) -> Unit) {
        listenerNext = block
    }

    fun setBack(block: (Int) -> Unit) {
        listenerBack = block
    }

    }
