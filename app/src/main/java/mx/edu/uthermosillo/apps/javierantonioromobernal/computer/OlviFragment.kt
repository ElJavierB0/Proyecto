package mx.edu.uthermosillo.apps.javierantonioromobernal.computer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

class OlviFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_olvi, container, false)

        val btnCode = v.findViewById<Button>(R.id.button3)
        val btncancel = v.findViewById<Button>(R.id.button4)
        val user = v.findViewById<EditText>(R.id.editTextText)
        val email = v.findViewById<EditText>(R.id.editTextText2)


        btnCode.setOnClickListener {
            val userText = user.text.toString()
            val emailText = email.text.toString()

            if (userText.isNotBlank() && emailText.isNotBlank()) {
                Toast.makeText(context, "Codigo Enviado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Datos Incompletos", Toast.LENGTH_SHORT).show()
            }
        }

        btncancel.setOnClickListener {
            cancel(it)
        }

        return v
    }

    private fun cancel(view: View){
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_olviFragment_to_loginFragment)
    }
}