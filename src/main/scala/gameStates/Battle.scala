package com.pokemon.gameStates

import com.NotGarbage.engine.{GameContainer, Renderer}
import com.NotGarbage.engine.gfx.{Image}
import com.NotGarbage.game.comunicators.{Cordinates}
import com.NotGarbage.game.gameStates.{GameState, GameStateManager}
import com.pokemon.entities.{Trainer, Pokemon}

//The class that simulates a battle, both double and single (and triple or whatever else nonsense)
//TEACHING:
//This extends the class GameState (written in java in the NotGarbage engine)
//Extending a class allows it to steal functionallity from said class
//Think of it like using GameState as a template, which here allows
//battle to interact with the engine
class BattleState(gsm: GameStateManager, val selfTrainer: Trainer, val oppoTrainer: Trainer, val background: Image) extends GameState(gsm) {
  var selfPokemon: Pokemon = selfTrainer.getFirstPokemon()
  var oppoPokemon: Pokemon = oppoTrainer.getFirstPokemon()

  //TEACHING:
  //The update function is what allows for the game to do calculations
  //and take in player input. This is how the game simulates
  override def update(gc: GameContainer, dt: Float): Unit = {
    //For how to take input ask your project superviser
    //but I'm gonna be simplifying it anyway so just wait till then
    //check whose turn it is, if player wait until input is given else figure out ai???
  }

  //TEACHING:
  //The render function is what prints images to the screen
  //You can print images, squares, and text using this
  //For how ask your project superviser or look in the renderer class
  override def render(gc: GameContainer, r: Renderer): Unit = {
    r.drawImage(background, 0, 0)
    r.drawImage(oppoPokemon.getFront, 380, 20)
    r.drawImage(selfPokemon.getBack, 0, 254)
  }

  //This function is to handle special conditions that need to be met
  //for the player to function, normally updating their coordinates
  //don't think it'll be super neccecary here but ya never know
  override def updatePlayer(): Unit = {

  }
}
