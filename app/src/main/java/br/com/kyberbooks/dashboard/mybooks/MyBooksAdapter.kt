package br.com.kyberbooks.dashboard.mybooks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.kyberbooks.R

class MyBooksAdapter : RecyclerView.Adapter<MyBooksAdapter.MyBooksViewHolder>(){

    private val myBooksItemList = mutableListOf<MyBooksItem>(
//     falta finalizar aqui
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_my_books, parent, false)
        return MyBooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyBooksViewHolder, position: Int) {
        holder.bind(myBooksItemList[position])
    }

    override fun getItemCount(): Int = myBooksItemList.size

    class MyBooksViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){

        var imageBooks: ImageView = itemview.findViewById(R.id.img_book_recycler_view)

        fun bind(myBooksItem: MyBooksItem){
//            falta finalizar aqui
        }
    }
}