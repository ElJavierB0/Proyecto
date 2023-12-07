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

class RegistroFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_registro, container, false)

        val btnCrear = v.findViewById<Button>(R.id.buton)
        val btnCancel = v.findViewById<Button>(R.id.buton2)
        val user = v.findViewById<EditText>(R.id.editTextText)
        val email = v.findViewById<EditText>(R.id.editTextText2)
        val password = v.findViewById<EditText>(R.id.editTextTextPassword)


        btnCrear.setOnClickListener {
            val userText = user.text.toString()
            val passwordText = password.text.toString()
            val emailText = email.text.toString()

            if (userText.isNotBlank() && passwordText.isNotBlank() && emailText.isNotBlank()) {
                Toast.makeText(context, "Usuario Creado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Datos Incompletos", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancel.setOnClickListener {
            cancel(it)
        }

        return v
    }

    private fun cancel(view: View){
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_registroFragment_to_loginFragment)
    }
}