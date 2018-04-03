package io.github.ziginsider.epam_laba_8

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.github.ziginsider.epam_laba_8.adapter.ItemsAdapter
import io.github.ziginsider.epam_laba_8.model.Character
import io.github.ziginsider.epam_laba_8.model.MockCharacter
import io.github.ziginsider.epam_laba_8.utils.toast
import kotlinx.android.synthetic.main.fragment_items.*

class ItemsFragment : BaseFragment() {

    interface ItemClickEventListener {
        fun onFragmentItemClick(item: Character)
    }

    private var listener: ItemClickEventListener? = null

    override val logTag = ItemsFragment::class.java.simpleName

    private var recyclerAdapter: ItemsAdapter? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ItemClickEventListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString()
                    + " must implement ItemClickEventListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val characters = MockCharacter(resources).generateStarWarsCharacters()
        setUpRecyclerView(characters)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_items
    }

    private fun setUpRecyclerView(items: List<Character>) {
        recyclerAdapter = ItemsAdapter(items,
                R.layout.item_view,
                {
                    activity.toast("Click $name !")
                    listener?.onFragmentItemClick(this)
                })
        with(recyclerView) {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = recyclerAdapter
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
        recyclerAdapter = null
    }
}