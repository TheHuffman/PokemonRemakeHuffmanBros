package com.pokemon.entities

//The Class which holds most trainer information that is shared between npcs
//and the player character alike, the player will own a trainer object
class Trainer {
  //The 6 pokemon the player owns
  private val pokemon: Array[Pokemon] = new Array[Pokemon](6)

  def addPokemon(poke: Pokemon): Boolean = {
    var nf: Boolean = true //Stands for not found
    var c: Int = 0
    //Loops through the array till is finds a null
    while(c < pokemon.size && nf) {
      if(pokemon(c) == null) {
        //If the slot is empty put the pokemon in
        nf = false
        pokemon(c) = poke
      }
      c += 1
    }
    //Returns true if it could not put in the pokemon
    return nf
  }

  def getFirstPokemon(): Pokemon = {
    //Returns the first pokemon in the array, for the begining of battles
    return pokemon(0)
  }
}
