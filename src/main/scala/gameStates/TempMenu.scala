package com.pokemon.gameStates

import com.NotGarbage.engine.{GameContainer, Renderer}
import com.NotGarbage.engine.gfx.{Image}
import com.NotGarbage.game.comunicators.{Button}
import com.NotGarbage.game.gameStates.{Menu, GameStateManager}
import com.pokemon.entities._
import com.pokemon.util.{PokemonHolders}

//This temperary and will not exist once the overworld is implimented
//But is an example of how to make a menu (which extends GameState behind the scenes)
class PokeSelectMenu(gsm: GameStateManager, buttons: Array[Button], x: Int, y: Int, offset: Int, background: Image)
extends Menu(gsm, buttons, x, y, offset, background) {
  //Creating player, actually not super needed right now, but might be
  val player: Player = new Player()
  //Gives the player to the gsm, which allows any GameState to access it
  gsm.setPlayer(player)

  override def buttonHandler(signal: Int): Unit = {
    val playerTrainer: Trainer = new Trainer()
    val challenger: Trainer = new Trainer()

    //Will need to make a cloning method for real pokemon gifting, probably a method in Pokemon
    //as right now they both have the same bidoof
    playerTrainer.addPokemon(PokemonHolders.POKEMON(399 - 1))
    challenger.addPokemon(PokemonHolders.POKEMON(399 - 1))

		if(signal == 0) {
      //Neutral Setup
		}
		else if(signal == 1) {
      //Weak to Setup
		}
		else if(signal == 2) {
      //Strong to Setup
		}
    //Give the player their trainer
    player.setTrainer(playerTrainer)

    //This is how you load up a new GameState typically
    gsm.states.pop()
    gsm.states.push(new BattleState(gsm, playerTrainer, challenger, new Image("/textures/backgrounds/battleBackground.png")))
    gsm.updatePlayer()
	}

  override def updatePlayer(): Unit = {

  }
}
