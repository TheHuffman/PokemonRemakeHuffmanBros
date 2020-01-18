package gameStates

import com.NotGarbage.engine.{GameContainer, Renderer}
import com.NotGarbage.engine.gfx.{Image, ImageTile}
import com.NotGarbage.game.comunicators.{Button}
import com.NotGarbage.game.gameStates.{GameState, GameStateManager, Menu}

class LoadingScreen(gsm: GameStateManager) extends GameState(gsm) {
  val background = new Image("/textures/backgrounds/loadingBackground.png")

  override def update(gc: GameContainer, dt: Float): Unit = {

  }

  override def render(gc: GameContainer, r: Renderer): Unit = {
    r.drawImage(background, 0, 0)
  }

  override def updatePlayer(): Unit = {

  }
}
