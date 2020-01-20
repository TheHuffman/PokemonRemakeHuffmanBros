package com.pokemon.entities

import com.NotGarbage.engine.gfx.{Image}

class Pokemon(val id: Int, val name: String, val front: String, val back: String) {
  private val texture: PokemonTexture = new PokemonTexture(front, back)

  def getFront(): Image = {
    return texture.frontTexture
  }

  def getBack(): Image = {
    return texture.backTexture
  }
}

class PokemonTexture(val front: String, val back: String) {
  val frontTexture: Image = new Image(front)
  val backTexture: Image = new Image(back)
}
