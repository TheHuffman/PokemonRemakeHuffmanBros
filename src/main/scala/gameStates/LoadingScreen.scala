package com.pokemon.gameStates

import com.NotGarbage.engine.{GameContainer, Renderer}
import com.NotGarbage.engine.gfx.{Image, ImageTile}
import com.NotGarbage.game.comunicators.{Button}
import com.NotGarbage.game.gameStates.{GameState, GameStateManager, Menu}
import com.NotGarbage.game.InputController
import com.pokemon.entities._
import com.pokemon.util.{PokemonHolders}

//CONNOR DOES NOT NEED TO TOUCH THIS
//LOADING IS A GABE ONLY TASK, IS VAUGELY COMPLEX
class LoadingScreen(gsm: GameStateManager) extends GameState(gsm) {
  val background = new Image("/textures/backgrounds/loadingBackground.png")
  val buttonSheet = new ImageTile("/textures/gui/menu_buttons.png", 100, 25)

  gsm.controller = new InputController()

  override def update(gc: GameContainer, dt: Float): Unit = {
    var bidoof: Pokemon = new Pokemon(399, "Bidoof", "/textures/pokemon/399.png", "/textures/pokemon/399b.png")
    PokemonHolders.POKEMON(bidoof.id - 1) = bidoof

    var buttons: Array[Button] = new Array[Button](3)
    for(i <- 0 until buttons.size) {
      buttons(i) = new Button(buttonSheet.getTileImage(i, 0), buttonSheet.getTileImage(i + 6, 0), i)
    }

    gsm.states.pop()
    gsm.states.push(new PokeSelectMenu(gsm, buttons , 100, 100, 60, background))
    gsm.updatePlayer()
  }

  override def render(gc: GameContainer, r: Renderer): Unit = {
    r.drawImage(background, 0, 0)
  }

  override def updatePlayer(): Unit = {

  }
}
