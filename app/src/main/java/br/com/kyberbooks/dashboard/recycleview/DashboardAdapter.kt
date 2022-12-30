package br.com.kyberbooks.dashboard.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.kyberbooks.R
import br.com.kyberbooks.databinding.ActivityDashboardBinding

class DashboardAdapter(

    private val context: Context,
    private val books: MutableList<ListBooksRegister>

): RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(binding: ActivityDashboardBinding) : RecyclerView.ViewHolder(binding.root){
        val recycleListBook = binding.recycleListBookRegister
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
       val books = ActivityDashboardBinding.inflate(LayoutInflater.from(context), parent, false)
        return DashboardViewHolder(ActivityDashboardBinding)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        var bookList = books [position]
        holder.recycleListBook = books

//        travei aqui, vi várias maneiras de construir e não estou acertando construção da sequência correta no código.
    }

    override fun getItemCount(): Int = books.size
}