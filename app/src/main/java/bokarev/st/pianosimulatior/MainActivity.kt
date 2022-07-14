package bokarev.st.pianosimulatior

import android.content.Context
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var quizeNoteFragment: QuizeNoteFragment
    lateinit var pianoModeFragment: PianoModeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_home -> {
                    /*val toast = Toast.makeText(applicationContext, "home", Toast.LENGTH_SHORT)
                    toast.show()*/
                    // Respond to navigation item 1 click
                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()


                }
                R.id.page_quize -> {
                    // Respond to navigation item 2 click

                    quizeNoteFragment = QuizeNoteFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, quizeNoteFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()

                }
                R.id.page_piano_mode -> {
                    // Respond to navigation item 2 click

                    pianoModeFragment = PianoModeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, pianoModeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    //val p1: Button = applicationContext.findViewById(R.id.p1)
                }

            }
            true
        }



    }

}