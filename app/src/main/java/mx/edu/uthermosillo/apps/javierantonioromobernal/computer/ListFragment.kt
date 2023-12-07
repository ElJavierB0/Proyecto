package mx.edu.uthermosillo.apps.javierantonioromobernal.computer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton

class ListFragment : Fragment() {

    private var comput: List<Computadoras> = emptyList()
    private lateinit var fabButton: FloatingActionButton
    private lateinit var adapter: ComputadorasAdapter // Aquí se declara la propiedad adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        initData()
        val recyclerView = view.findViewById<RecyclerView>(R.id.countriesRecycler)
        adapter = ComputadorasAdapter(comput) // Aquí se inicializa la propiedad adapter
        val layoutManager = LinearLayoutManager(container?.context)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        fabButton = view.findViewById(R.id.fab_btn)

        fabButton.setOnClickListener {
            showBottonSheet()
        }

        val bottomNavigationView: BottomNavigationView = view.findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item1 -> {
                    PriL(view)
                    true
                }
                R.id.menu_item2 -> {
                    PriP(view)
                    true
                }
                R.id.menu_item3 -> {
                    PriI(view)
                    true
                }
                else -> false
            }
        }
        return view
    }

    private fun initData() {

        comput = listOf(
            Computadoras(1, "192.168.8.100", "HP Pavilion series", "00:8A:1B:2C:3D:4E", "monitor", "User"),
            Computadoras(2, "192.168.7.200", "Dell Inspiron series", "00:7A:8B:1C:2D:3E", "laptop", "Admin"),
            Computadoras(3,"192.168.6.300","Toshiba Lax","00:6A:7B:8C:1D:2E","monitor", ""),
            Computadoras(4, "192.168.5.400", "Lenovo IdeaCentre series", "00:5A:6B:7C:8D:1E", "laptop", "User"),
            Computadoras(5, "192.168.4.500", "Asus A-20", "00:4A:5B:6C:7D:8E", "monitor", "Admin"),
            Computadoras(6, "192.168.3.600", "Lenovo ThinkPad series", "00:3A:4B:5C:6D:7E", "laptop", ""),
            Computadoras(7,"192.168.2.700", "iMac", "00:2A:3B:4C:5D:6E", "monitor", ""),
            Computadoras(8, "192.168.1.800", "MacBook ", "00:1A:2B:3C:4D:5E", "laptop", "")
        )
    }

    private fun PriI(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_listFragment_to_infoFragment)
    }

    private fun PriL(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_listFragment_to_listFragment)
    }

    private fun PriP(view: View) {
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_listFragment_to_priFragment)
    }

    private fun showBottonSheet() {
        val bottonSheetView = layoutInflater.inflate(
            R.layout.botton_sheet,
            view?.findViewById(R.id.bottonSheetContainer),
            false
        )
        val dialog = BottomSheetDialog(requireContext())
        dialog.setContentView(bottonSheetView)

        val ipEditText = bottonSheetView.findViewById<TextInputEditText>(R.id.ip)
        val modelEditText = bottonSheetView.findViewById<TextInputEditText>(R.id.model)
        val addEditText = bottonSheetView.findViewById<TextInputEditText>(R.id.add)
        val imagenEditText = bottonSheetView.findViewById<TextInputEditText>(R.id.imagen)
        val tipoEditText = bottonSheetView.findViewById<TextInputEditText>(R.id.tipo)
        val aggButton = bottonSheetView.findViewById<MaterialButton>(R.id.agg)

        aggButton.setOnClickListener {
            val ip = ipEditText.text.toString()
            val modelo = modelEditText.text.toString()
            val imagen = imagenEditText.text.toString()
            val add = addEditText.text.toString()
            val tip = tipoEditText.text.toString()

            if (ip.isNotEmpty() && modelo.isNotEmpty() && imagen.isNotEmpty() && add.isNotEmpty() && tip.isNotEmpty()) {
                // Crear una nueva lista mutable y agregar los elementos existentes
                val nuevaLista = comput.toMutableList()
                // Agregar el nuevo elemento a la nueva lista
                nuevaLista.add(Computadoras(nuevaLista.size + 1, ip, modelo, imagen, add, tip))
                // Actualizar la propiedad comput con la nueva lista
                comput = nuevaLista.toList()

                // Notificar al adaptador sobre el cambio en los datos
                adapter = ComputadorasAdapter(comput) // Actualizar el adaptador con la nueva lista
                val recyclerView = view?.findViewById<RecyclerView>(R.id.countriesRecycler)
                recyclerView?.adapter = adapter // Establecer el nuevo adaptador en el RecyclerView
                adapter.notifyDataSetChanged()

                dialog.dismiss()

                // Mostrar una Toast indicando que se agregó correctamente
                Toast.makeText(
                    requireContext(),
                    "Computadora agregada correctamente",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Completa todos los campos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        dialog.show()
    }

}
