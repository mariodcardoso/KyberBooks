package br.com.kyberbooks.dashboard.mybooks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.kyberbooks.R
import br.com.kyberbooks.databinding.ActivityBookDataBinding
import br.com.kyberbooks.databinding.ActivityMyBooksBinding
import com.bumptech.glide.Glide

class MyBooksAdapter : RecyclerView.Adapter<MyBooksAdapter.MyBooksViewHolder>(){

    private val myBooksItemList = listOf<MyBooksItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_my_books, parent, false)
        return MyBooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyBooksViewHolder, position: Int) {
        holder.bind(myBooksItemList[position])
    }

    override fun getItemCount(): Int = myBooksItemList.size

    class MyBooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var imageBooks: ImageView = itemView.findViewById(R.id.img_book_recycler_view)

        fun bind(myBooksItem: MyBooksItem){
            imageBooks.setImageResource(myBooksItem.image)

            Glide.with(this.imageBooks).load("https://edit.org/images/cat/book-covers-big-2019101610.jpg").into(imageBooks)
            }
        }
    }
