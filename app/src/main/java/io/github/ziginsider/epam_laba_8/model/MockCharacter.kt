package io.github.ziginsider.epam_laba_8.model

class MockCharacter {
    companion object {
        fun generateStarWarsCharacters(): List<Character> {
            val characters = ArrayList<Character>()
            characters.add(Character(0, "Joda", "Description"))
            return characters
        }
    }
}