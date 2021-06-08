package uz.uzsoft.qqbtrans.ui.screen

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.uzsoft.qqbtrans.R
import uz.uzsoft.qqbtrans.data.sourse.local.sharedPreference.LocalStorage
import uz.uzsoft.qqbtrans.databinding.FragmentSplashBinding


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val binding by viewBinding(FragmentSplashBinding::bind)
    private var storage = LocalStorage.getInstance()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val counter: Boolean = storage.getRemember()

        Log.d("TTT", "splash if $counter")

//        Executors.newSingleThreadExecutor().execute {
//            Thread.sleep(5000)
//            if (counter) {
//                openLogin()
//                Log.d("TTT", "splash if")
//            } else {
//                Log.d("TTT", "splash else")
//                openRegis()
//            }
//        }
        val imageSplash = view.findViewById<ImageView>(R.id.imageSplash)

        imageSplash.setOnClickListener {
            Toast.makeText(view.context, "imageSplash", Toast.LENGTH_SHORT).show()
        }

        Executors.newSingleThreadExecutor().execute {
            Thread.sleep(2000)
            if (counter) {
                activity?.runOnUiThread {
                    openLogin()
                    Log.d("TTT", "splash if")
                }
            } else {
                activity?.runOnUiThread {
                    openLogin()
                    Log.d("TTT", "splash else")
                    openRegis()

                }
            }
        }
    }


    private fun openRegis() {
//        fragmentManager.beginTransaction()
//            .replace(R.id.nav_host_fragment,)
//            //  .addToBackStack(null) remove this line
//            .commit();
        findNavController().navigate(R.id.nav_login)


    }

    private fun openLogin() {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentLayout, IntroFragment(), "Intro")
//            .commit()
//    }
        findNavController().navigate(R.id.nav_login)
    }
}