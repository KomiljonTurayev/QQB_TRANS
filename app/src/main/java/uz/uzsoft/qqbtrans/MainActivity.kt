package uz.uzsoft.qqbtrans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isGone
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import uz.uzsoft.qqbtrans.R

class MainActivity : AppCompatActivity() {
    lateinit var qqb: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_main, R.id.nav_trans, R.id.nav_pay, R.id.nav_more, R.id.nav_monitoring
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.nav_splash -> {
                    navView.isGone = true
//                    toolbar.isGone = true
//                    container.setPadding(0, 0, 0, 0)
//                    this.container.hideKeyboard()

                }

                R.id.nav_main->{
                    navView.isGone = false
                }
    R.id.nav_login->{
                    navView.isGone = true
                }




            }

        }
    }
}