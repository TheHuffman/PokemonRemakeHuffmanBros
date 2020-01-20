package com.pokemon.entities

class Trainer {
  private val pokemon: Array[Pokemon] = new Array[Pokemon](6)
  initialize()

  def addPokemon(poke: Pokemon): Boolean = {
    var s: Boolean = false
    for(i <- 0 until pokemon.size) {
      if(pokemon(i) == null && !s) {
        s = true
        pokemon(i) = poke
      }
    }

    return if(s) {true} else {false}
  }

  def getFirstPokemon(): Pokemon = {
    return pokemon(0)
  }

  private def initialize(): Unit = {
    for(i <- 0 until pokemon.size) {
      pokemon(i) = null
    }
  }
}
