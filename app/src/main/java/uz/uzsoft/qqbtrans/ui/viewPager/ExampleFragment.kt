package uz.uzsoft.qqbtrans.ui.viewPager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.uzsoft.qqbtrans.R
import uz.uzsoft.qqbtrans.databinding.IntroPageBinding

class ExampleFragment : Fragment(R.layout.intro_page) {
    private lateinit var binding: IntroPageBinding

    private var listenerNext: ((Int)->Unit)?=null
    private var listenerBack: ((Int) -> Unit)? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding= IntroPageBinding.bind(view)
        val bundle = requireArguments()
        val color=bundle.getInt("COLOR",0)
       binding.image.setImageResource(bundle.getInt("IMAGE",0))
        binding.layoutContent.setBackgroundColor(color)
        binding.infoIntro.text=bundle.getString("INFO","")
        binding.back.setOnClickListener {
            listenerBack?.invoke(color)
        }
        binding.next.setOnClickListener {
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
