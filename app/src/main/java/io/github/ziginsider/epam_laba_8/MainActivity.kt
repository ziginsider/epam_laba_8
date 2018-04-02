package io.github.ziginsider.epam_laba_8

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.ziginsider.epam_laba_8.model.MockCharacter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val characters = MockCharacter(resources).generateStarWarsCharacters()
    }
}