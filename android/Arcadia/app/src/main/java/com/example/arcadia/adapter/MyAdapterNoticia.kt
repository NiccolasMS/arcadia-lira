import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.arcadia.R
import com.example.arcadia.models.Noticia

class MyAdapterNoticia(val listaNoticia: List<Noticia>, val onClick: (Noticia) -> Unit) :
    RecyclerView.Adapter<MyAdapterNoticia.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titulo = itemView.findViewById<TextView>(R.id.titulo_noticia)
        var descricao = itemView.findViewById<TextView>(R.id.descricao_noticia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.row_notificacao_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaNoticia.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val noticia = listaNoticia[position]

        holder.titulo.text = noticia.titulo
        holder.descricao.text = noticia.descricao

        holder.itemView.setOnClickListener {
            onClick(noticia)
        }
    }
}