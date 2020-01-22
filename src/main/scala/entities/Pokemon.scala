package com.pokemon.entities

import com.NotGarbage.engine.gfx.{Image}

//The Class used to simulate a pokemon
class Pokemon(val id: Int, val name: String, val front: String, val back: String) {
  private val texture: PokemonTexture = new PokemonTexture(front, back)

  //Methods for getting textures of the pokemon
  def getFront(): Image = {
    return texture.frontTexture
  }

  def getBack(): Image = {
    return texture.backTexture
  }
}

//The class that makes accessing the pokemon's textures more intuitive
class PokemonTexture(val front: String, val back: String) {
  val frontTexture: Image = new Image(front)
  val backTexture: Image = new Image(back)
}
