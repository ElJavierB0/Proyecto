package mx.edu.uthermosillo.apps.javierantonioromobernal.computer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class InfoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_info, container, false)

        // Acceder al BottomNavigationView desde el diseño del fragmento
        val bottomNavigationView: BottomNavigationView = v.findViewById(R.id.bottomNavigationView)

        // Manejar las selecciones del BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener() { item ->
            when (item.itemId) {
                R.id.menu_item1 -> {
                    // Acción para el primer ítem
                    PriL(v)
                    true
                }
                R.id.menu_item2 -> {
                    // Acción para el segundo ítem
                    PriP(v)
                    true
                }
                R.id.menu_item3 -> {
                    // Acción para el tercer ítem
                    PriI(v)
                    true
                }

                // Agrega más casos según sea necesario
                else -> false
            }
        }
        return v
    }

    private fun PriI(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_infoFragment_to_infoFragment)
    }

    private fun PriL(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_infoFragment_to_listFragment)
    }

    private fun PriP(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_infoFragment_to_priFragment)
    }
    private fun PriS(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_infoFragment_to_loginFragment)
    }
}
