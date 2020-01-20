package com.pokemon.gameStates

import com.NotGarbage.engine.{GameContainer, Renderer}
import com.NotGarbage.engine.gfx.{Image}
import com.NotGarbage.game.comunicators.{Button}
import com.NotGarbage.game.gameStates.{Menu, GameStateManager}
import com.pokemon.entities._
import com.pokemon.util.{PokemonHolders}

class PokeSelectMenu(gsm: GameStateManager, buttons: Array[Button], x: Int, y: Int, offset: Int, background: Image)
extends Menu(gsm, buttons, x, y, offset, background) {
  val player: Player = new Player()

  gsm.setPlayer(player)

  override def buttonHandler(signal: Int): Unit = {
    val playerTrainer: Trainer = new Trainer()
    val challenger: Trainer = new Trainer()
    var worked: Boolean = false

    //Will need to make a cloning method for real pokemon gifting, probably a method in Pokemon
    worked = playerTrainer.addPokemon(PokemonHolders.POKEMON(399 - 1))
    worked = challenger.addPokemon(PokemonHolders.POKEMON(399 - 1))

		if(signal == 0) {
      //Neutral Setup
		}
		else if(signal == 1) {
      //Weak to Setup
		}
		else if(signal == 2) {
      //Strong to Setup
		}
    player.setTrainer(playerTrainer)

    if(worked) {
      gsm.states.pop()
      gsm.states.push(new BattleState(gsm, playerTrainer, challenger, new Image("/textures/backgrounds/battleBackground.png")))
      gsm.updatePlayer()
    }
	}

  override def updatePlayer(): Unit = {

  }
}
