package mx.edu.uthermosillo.apps.javierantonioromobernal.computer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import android.content.Intent
import android.widget.Toast


class LoginFragment : Fragment() {

    private var users: List<User> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_login, container, false)

        val btnLogin = v.findViewById<Button>(R.id.button)
        val btnGoRegister = v.findViewById<Button>(R.id.button2)
        val txtOlvi = v.findViewById<TextView>(R.id.textView2)
        val user = v.findViewById<EditText>(R.id.editTextText)
        val password = v.findViewById<EditText>(R.id.editTextTextPassword3)


        btnLogin.setOnClickListener {
            validUsers()

            if(user.text != null && password.text != null) {

                val nam = user.text.toString()
                val pass = password.text.toString()

                if(checkUser(nam, pass, users)){
                    Toast.makeText(context,"Login Correcto",Toast.LENGTH_SHORT)
                        .show()

                    //TODO Cambiar MainActivity por PriFragment
                    val controller: NavController = Navigation.findNavController(it)
                    controller.navigate(R.id.priFragment)

                } else {
                    Toast.makeText(context,
                        "Las credenciales no coinciden",
                        Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(
                    context,
                    "Ambos campos son requeridos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnGoRegister.setOnClickListener {
           Medio(it)
        }

        txtOlvi.setOnClickListener {
            Final(it)
        }

        return v
    }
    private fun checkUser(username: String, password: String,
                          users: List<User>): Boolean {
        return users.any { user ->
            username == user.name && password == user.password
        }
    }
    private fun validUsers() {
    users = listOf(
        User(1, "Javier", "jav@gmail.com", "12345"),
        User(2, "Rene", "ren@gmail.com", "12345"),
        User(3, "Alan", "ala@gmail.com", "12345"),
        User(4, "Guille", "gui@gmail.com", "12345"),
        User(5, "Pablo", "pab@gmail.com", "12345"),
    )
    }
    private fun Medio(view: View){
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_loginFragment_to_registroFragment)
    }
    private fun Final(view: View){
        val controller: NavController = Navigation.findNavController(view)
        controller.navigate(R.id.action_loginFragment_to_olviFragment)
    }
}