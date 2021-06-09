package uz.uzsoft.qqbtrans.ui.screen

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import uz.uzsoft.qqbtrans.R
import uz.uzsoft.qqbtrans.data.sourse.local.sharedPreference.LocalStorage
import uz.uzsoft.qqbtrans.databinding.IntroBinding
import uz.uzsoft.qqbtrans.ui.viewPager.Adapter
import uz.uzsoft.qqbtrans.utils.extentions.toDarkenColor

class IntroFragment : Fragment(R.layout.intro) {

    private var storage = LocalStorage.getInstance()
    private val binding by viewBinding(IntroBinding::bind)

    private lateinit var adapter: Adapter
    private val color = listOf(
        Color.parseColor("#E74C3A"),
        Color.parseColor("#F39C11"),
        Color.parseColor("#23B574"),
        Color.parseColor("#F5656C"),
        Color.parseColor("#9F76D5")
    )
    private val image = listOf(
        R.drawable.grow,
        R.drawable.hour, R.drawable.splash, R.drawable.p1, R.drawable.save
    )
    private val info = listOf(
        "Increase your money easily and quickly",
        "Constant communication and quality service",
        "Security is strongly protected",
        "Register and activate your account",
        "Keep your fund easy and safe"
    )
    private lateinit var currentView: View
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        currentView = view
        adapter = Adapter(color, image, info, requireActivity())
        binding.pager.adapter = adapter
        adapter.setBack { binding.pager.currentItem = binding.pager.currentItem - 1 }
        adapter.setNext {
            if (binding.pager.currentItem != info.size - 1) {
                binding.pager.setCurrentItem(binding.pager.currentItem + 1, true)
            } else {
                openLogin()
            }
        }
        TabLayoutMediator(binding.tabLay, binding.pager) { tab, position -> }.attach()
        binding.pager.registerOnPageChangeCallback(pageChangeCallback)
    }

    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                activity?.window?.navigationBarColor = color[position].toDarkenColor()
                activity?.window?.statusBarColor = color[position].toDarkenColor()
            }
        }
    }

    private fun openLogin() {
//        fragmentManager?.beginTransaction()
//            ?.replace(R.id.nav_login, LoginFragment(), "Login")
//            ?.addToBackStack("Login")?.commit()

        findNavController().popBackStack()
        findNavController().navigate(R.id.nav_login)
    }
}