package com.pokemon.entities

class Player {
  private var trainer: Trainer = null

  def setTrainer(t: Trainer): Unit = {
    trainer = t
  }

  def getTrainer(): Trainer = {
    return trainer
  }
}
