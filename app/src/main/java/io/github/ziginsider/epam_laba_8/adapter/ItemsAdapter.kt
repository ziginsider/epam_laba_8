package io.github.ziginsider.epam_laba_8.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import io.github.ziginsider.epam_laba_8.R
import io.github.ziginsider.epam_laba_8.model.Character
import io.github.ziginsider.epam_laba_8.utils.inflate
import kotlinx.android.synthetic.main.item_view.view.*

class ItemsAdapter(val items: List<Character>,
                   val layoutResId: Int,
                   private var itemClick: Character.() -> Unit = {})
    : RecyclerView.Adapter<ItemsAdapter.Holder>() {

    class Holder (itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = parent inflate layoutResId
        val viewHolder = Holder(view)
        val itemView = viewHolder.itemView
        itemView.setOnClickListener {
            val adapterPosition = viewHolder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClick(itemView, adapterPosition)
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.itemView.bind(item)
    }

    protected open fun onItemClick(itemView: View, position: Int) {
        items[position].itemClick()
    }

    fun View.bind(item: Character) {
        heroName.text = item.name
        when(item.id) {
            0 -> heroImage.setImageResource(R.drawable.yoda)
            1 -> heroImage.setImageResource(R.drawable.luke_skywalker)
            2 -> heroImage.setImageResource(R.drawable.princess_leia)
            3 -> heroImage.setImageResource(R.drawable.han_solo)
            4 -> heroImage.setImageResource(R.drawable.chewbacca)
            5 -> heroImage.setImageResource(R.drawable.darth_vader)
            6 -> heroImage.setImageResource(R.drawable.r2_d2)
            7 -> heroImage.setImageResource(R.drawable.c_3po)
        }
    }

    override fun getItemCount() = items.size
}