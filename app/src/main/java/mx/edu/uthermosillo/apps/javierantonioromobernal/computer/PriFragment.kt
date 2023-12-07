package mx.edu.uthermosillo.apps.javierantonioromobernal.computer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class PriFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_pri, container, false)

        val bottomNavigationView: BottomNavigationView = v.findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item1 -> {
                    PriL(v)
                    true
                }
                R.id.menu_item2 -> {
                    PriP(v)
                    true
                }
                R.id.menu_item3 -> {
                    PriI(v)
                    true
                }
                else -> false
            }
        }
        return v
    }

    private fun PriI(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_priFragment_to_infoFragment)
    }

    private fun PriL(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_priFragment_to_listFragment)
    }

    private fun PriP(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_priFragment_to_priFragment)
    }

    private fun PriS(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_priFragment_to_loginFragment)
    }
}
