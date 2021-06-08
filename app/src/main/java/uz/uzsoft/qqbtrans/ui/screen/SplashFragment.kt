package uz.uzsoft.qqbtrans.ui.screen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.uzsoft.qqbtrans.R
import uz.uzsoft.qqbtrans.data.sourse.local.sharedPreference.LocalStorage
import java.util.concurrent.Executors

class SplashFragment : Fragment() {

    private var storage = LocalStorage.getInstance()
    private var executor = Executors.newSingleThreadExecutor()
    private var handle = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val counter: Boolean = storage.getRemember()

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
        findNavController().navigate(R.id.nav_registration)
    }
}