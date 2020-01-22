package com.pokemon.entities

//The class that holders the player specific data
class Player {
  //The trainer the player is playing as
  private var trainer: Trainer = null

  def setTrainer(t: Trainer): Unit = {
    trainer = t
  }

  def getTrainer(): Trainer = {
    return trainer
  }
}
