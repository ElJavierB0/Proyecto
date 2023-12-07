package mx.edu.uthermosillo.apps.javierantonioromobernal.computer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ComputadorasAdapter(private var compu: List<Computadoras>): RecyclerView.Adapter<ComputadorasAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_computadoras, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val comp = compu[position]
        holder.render(comp)

        //aquí se aplica la lógica. ej: onClickListener
    }

    override fun getItemCount(): Int {
        return compu.size
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.country_name)
        val capital: TextView = view.findViewById(R.id.country_capital)
        val continent: TextView = view.findViewById(R.id.country_continent)
        val image: ImageView = view.findViewById(R.id.mage)

        fun render(compus: Computadoras) {
            name.text = compus.ip + ", "
            capital.text = compus.model
            continent.text = compus.tip

            // Cambia "device_selector" por el nombre de tu selector
            val imageResource = when {
                compus.image == "laptop" -> R.drawable.laptop
                compus.image == "monitor" -> R.drawable.monitor
                else -> R.drawable.ip // Puedes usar una imagen por defecto si no hay coincidencia
            }

            image.setImageResource(imageResource)
        }
    }
}