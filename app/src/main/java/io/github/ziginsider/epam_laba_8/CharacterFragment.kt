package io.github.ziginsider.epam_laba_8

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import io.github.ziginsider.epam_laba_8.utils.asDp
import kotlinx.android.synthetic.main.item_view.view.*

class CharacterFragment : BaseFragment() {

    private val ITEM_ID_KEY = "itemIdKey"
    private val ITEM_DECRIPTION_KEY = "itemDescriptionKey"

    val characterId: Int by lazy { arguments.getInt(ITEM_ID_KEY) }
    val characterDescription: String by lazy { arguments.getString(ITEM_DECRIPTION_KEY) }

    override val logTag = CharacterFragment::class.java.simpleName

    override fun getLayout(): Int {
        return R.layout.fragment_character
    }

    companion object {
        fun newInstance(itemId: Int, itemDescription: String): CharacterFragment {
            return CharacterFragment().apply {
                arguments = Bundle().apply {
                    putInt(ITEM_ID_KEY, itemId)
                    putString(ITEM_DECRIPTION_KEY, itemDescription)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //characterId = savedInstanceState?.getInt(ITEM_ID_KEY) ?: arguments.getInt(ITEM_ID_KEY)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        //outState?.putInt(ITEM_ID_KEY, characterId)
        super.onSaveInstanceState(outState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val characterImage = view?.findViewById(R.id.image_view_character) as ImageView
        val characterText = view?.findViewById(R.id.text_view_character) as TextView
        characterText.text = characterDescription
        when (characterId) {
            0 -> {
                //characterImage.layoutParams.height = 30.asDp
                characterImage.setImageResource(R.drawable.yoda)
            }
            1 -> characterImage.setImageResource(R.drawable.luke_skywalker)
            2 -> characterImage.setImageResource(R.drawable.princess_leia)
            3 -> characterImage.setImageResource(R.drawable.han_solo)
            4 -> characterImage.setImageResource(R.drawable.chewbacca)
            5 -> characterImage.setImageResource(R.drawable.darth_vader)
            6 -> characterImage.setImageResource(R.drawable.r2_d2)
            7 -> characterImage.setImageResource(R.drawable.c_3po)
        }
    }
}