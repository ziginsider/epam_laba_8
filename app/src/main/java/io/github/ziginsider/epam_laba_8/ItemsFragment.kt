package io.github.ziginsider.epam_laba_8

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import io.github.ziginsider.epam_laba_8.adapter.ItemsAdapter
import io.github.ziginsider.epam_laba_8.model.Character
import io.github.ziginsider.epam_laba_8.model.MockCharacter
import kotlinx.android.synthetic.main.fragment_items.*

/**
 * Implements First Fragment that contains a list which allows to chose second Fragment
 *
 * <p>Declares interface <tt>ItemClickEventListener</tt> for getting
 * touch to Activity
 *
 * @author Alex Kisel
 * @since 2018-04-03
 */
class ItemsFragment : BaseFragment() {
    override val logTag = ItemsFragment::class.java.simpleName

    interface ItemClickEventListener {
        fun onFragmentItemClick(item: Character)

    }
    private var listener: ItemClickEventListener? = null

    private var recyclerAdapter: ItemsAdapter? = null

    override fun getLayout(): Int {
        return R.layout.fragment_items
    }

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

    private fun setUpRecyclerView(items: List<Character>) {
        recyclerAdapter = ItemsAdapter(items,
                R.layout.item_view,
                { listener?.onFragmentItemClick(this) })
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