package io.github.ziginsider.epam_laba_8

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import io.github.ziginsider.epam_laba_8.model.Character
import io.github.ziginsider.epam_laba_8.utils.isPortrait

class MainActivity : AppCompatActivity(), ItemsFragment.ItemClickEventListener {
    private val CURRENT_ITEM_ID_KEY = "currentItemIdKey"
    private val CURRENT_DESCRIPTION_KEY = "currentDescriptionKey"

    private var currentItemId = 0
    private var currentDecription = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentItemId = savedInstanceState?.getInt(CURRENT_ITEM_ID_KEY) ?: 0
        currentDecription = savedInstanceState?.getString(CURRENT_DESCRIPTION_KEY)
                ?: resources.getString(R.string.yoda_description)

        if (isPortrait()) {
            setItemsFragmentPortrait(ItemsFragment())
        } else {
            setItemsFragmentLandscape(ItemsFragment())
            setCharacterFragmentLandscape(CharacterFragment
                    .newInstance(currentItemId, currentDecription))
        }
    }

    private fun setItemsFragmentPortrait(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_layout, fragment)
                .commit()
    }

    private fun setItemsFragmentLandscape(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.items_frame, fragment)
                .commit()
    }

    private fun setCharacterFragmentPortrait(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_layout, fragment)
                .addToBackStack(null)
                .commit()
    }

    private fun setCharacterFragmentLandscape(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.character_frame, fragment)
                .commit()
    }

    override fun onFragmentItemClick(item: Character) {
        currentItemId = item.id
        currentDecription = item.description

        val fragment = CharacterFragment.newInstance(currentItemId, currentDecription)

        if (isPortrait()) setCharacterFragmentPortrait(fragment)
        else setCharacterFragmentLandscape(fragment)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(CURRENT_ITEM_ID_KEY, currentItemId)
        outState?.putString(CURRENT_DESCRIPTION_KEY, currentDecription)
    }
}