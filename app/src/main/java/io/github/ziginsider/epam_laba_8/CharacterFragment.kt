package io.github.ziginsider.epam_laba_8

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Implements Second Fragment that contains the selected
 * [io.github.ziginsider.epam_laba_8.model.Character]
 *
 * @author Alex Kisel
 * @since 2018-04-03
 */
class CharacterFragment : BaseFragment() {
    override val logTag = CharacterFragment::class.java.simpleName

    private val ITEM_ID_KEY = "itemIdKey"
    private val ITEM_DECRIPTION_KEY = "itemDescriptionKey"

    val characterId: Int by lazy { arguments.getInt(ITEM_ID_KEY) }
    val characterDescription: String by lazy { arguments.getString(ITEM_DECRIPTION_KEY) }

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

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val characterImage = view?.findViewById(R.id.image_view_character) as ImageView
        val characterText = view?.findViewById(R.id.text_view_character) as TextView
        characterText.text = characterDescription
        when (characterId) {
            0 -> characterImage.setImageResource(R.drawable.yoda)
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