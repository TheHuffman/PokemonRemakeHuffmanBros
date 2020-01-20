package com.pokemon.gameStates

import com.NotGarbage.engine.{GameContainer, Renderer}
import com.NotGarbage.engine.gfx.{Image}
import com.NotGarbage.game.comunicators.{Cordinates}
import com.NotGarbage.game.gameStates.{GameState, GameStateManager}
import com.pokemon.entities.{Trainer, Pokemon}

class BattleState(gsm: GameStateManager, val selfTrainer: Trainer, val oppoTrainer: Trainer, val background: Image) extends GameState(gsm) {
  var selfPokemon: Pokemon = selfTrainer.getFirstPokemon()
  var oppoPokemon: Pokemon = oppoTrainer.getFirstPokemon()

  override def update(gc: GameContainer, dt: Float): Unit = {
    //check whose turn it is, if player wait until input is given else figure out ai???
  }

  override def render(gc: GameContainer, r: Renderer): Unit = {
    r.drawImage(background, 0, 0)
    r.drawImage(oppoPokemon.getFront, 380, 20)
    r.drawImage(selfPokemon.getBack, 0, 254)
  }

  override def updatePlayer(): Unit = {

  }
}
