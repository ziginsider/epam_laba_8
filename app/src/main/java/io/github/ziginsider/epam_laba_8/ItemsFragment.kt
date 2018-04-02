package io.github.ziginsider.epam_laba_8

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.github.ziginsider.epam_laba_8.adapter.ItemsAdapter
import io.github.ziginsider.epam_laba_8.model.Character
import io.github.ziginsider.epam_laba_8.model.MockCharacter
import io.github.ziginsider.epam_laba_8.utils.toast
import kotlinx.android.synthetic.main.fragment_items.*

class ItemsFragment : BaseFragment() {

    override val logTag = ItemsFragment::class.java.simpleName

    private var recyclerAdapter: ItemsAdapter? = null

    override fun getLayout(): Int {
        return R.layout.fragment_items
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setUpRecyclerView(items: List<Character>) {
        recyclerAdapter = ItemsAdapter(items,
                R.layout.item_view,
                { activity.toast("Click $name !") })
        with(recyclerView) {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = recyclerAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val characters = MockCharacter(resources).generateStarWarsCharacters()
        setUpRecyclerView(characters)
    }
}