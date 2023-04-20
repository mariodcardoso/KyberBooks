package br.com.kyberbooks.dashboard.mybooks.activesearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.kyberbooks.R
import com.bumptech.glide.Glide

class ActiveSearchMainAdapter : RecyclerView.Adapter<ActiveSearchMainAdapter.ActiveSearchMainViewHolder>() {

    private val imageActiveMain = listOf<ActiveMainData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveSearchMainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_active_search, parent, false)
        return ActiveSearchMainViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActiveSearchMainViewHolder, position: Int) {
        holder.bind(imageActiveMain[position])
    }

    override fun getItemCount(): Int = imageActiveMain.size

    class ActiveSearchMainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val listActiveMain: ImageView = itemView.findViewById(R.id.rcv_list_main)

        fun bind(imageActiveMain: ActiveMainData){
            listActiveMain.setImageResource(imageActiveMain.imageMain)

            Glide.with(this.listActiveMain).load("https://edit.org/images/cat/book-covers-big-2019101610.jpg").into(listActiveMain)
        }
    }
}