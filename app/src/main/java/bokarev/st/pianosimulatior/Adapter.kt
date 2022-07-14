package bokarev.st.pianosimulatior

import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Context,
              private val list: ArrayList<Model>,
              private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val iconIV: ImageView = view.findViewById(R.id.iconIV)
        val titleTV: TextView = view.findViewById(R.id.titleTV)
        val subtitleTV: TextView = view.findViewById(R.id.subtitleTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cell_view,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.iconIV.setImageDrawable(ContextCompat.getDrawable(context, data.icon))
        holder.titleTV.text = data.title
        holder.subtitleTV.text = data.subtitle

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener()
        }
    }
}