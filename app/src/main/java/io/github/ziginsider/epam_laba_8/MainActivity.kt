package io.github.ziginsider.epam_laba_8

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import io.github.ziginsider.epam_laba_8.model.Character

class MainActivity : AppCompatActivity(), ItemsFragment.ItemClickEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) setFragment(ItemsFragment())
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_layout, fragment)
                .commit()
    }

    private fun setFragmentToStack(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_layout, fragment)
                .addToBackStack(null)
                .commit()
    }

    override fun onFragmentItemClick(item: Character) {
        setFragmentToStack(CharacterFragment.newInstance(item.id, item.description))
    }
}