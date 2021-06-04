package uz.uzsoft.qqbtrans.ui.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import uz.uzsoft.qqbtrans.sourse.local.shared.LocalStorage
import uz.uzsoft.qqbtrans.R
import java.util.concurrent.Executors

class SplashFragment : Fragment() {

    private var storage = LocalStorage.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Executors.newSingleThreadExecutor().execute {
            Thread.sleep(5000)
//            if (storage.getRemember()) {
////                runOnUiThread {
//                openCard()
////            }
//            } else {
////                runOnUiThread {
//                openLogin()
//            findNavController().navigate(R.id.nav_registration)
//            findNavController().popBackStack(R.id.nav_registration, false)
            Log.d("TTT", "splash else")
            openCard()
//            }
//            }
        }
    }


    private fun openCard() {
//        fragmentManager.beginTransaction()
//            .replace(R.id.nav_host_fragment,)
//            //  .addToBackStack(null) remove this line
//            .commit();
//        findNavController().navigate(R.id.nav_login)
    }

    private fun openLogin() {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentLayout, IntroFragment(), "Intro")
//            .commit()
//    }
        findNavController().navigate(R.id.nav_registration)
    }
}