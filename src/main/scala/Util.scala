package com.pokemon.util

import com.pokemon.entities.{Pokemon}

//This file just holds things we want to access from anywhere without trouble
//That is what the object does, do not use in most places until outside of this
//file for similar purposes

//Holders the grand list of all the pokemon, moves, and related
//The pokemon in POKEMON are templates, and will need to be cloned
//off when grabbed out of the list (or the trainer will be weilding the template)
object PokemonHolders {
  val POKE_NUM: Int = 721

  val POKEMON: Array[Pokemon] = new Array[Pokemon](POKE_NUM)
  //moves
  //abillities

  //Add a method that allows for safe cloning from POKEMON
  //so that no weird errors occur
}
