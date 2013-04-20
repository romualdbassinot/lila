package lila.app
package actor

import akka.actor._

import play.api.templates._
import views.{ html => V }

private[app] final class Renderer extends Actor {

  def receive = {

    case lila.game.actorApi.RenderFeaturedJs(game) => 
      V.game.featuredJsNoCtx(game)

    case lila.notification.actorApi.RenderNotification(id, from, body) => 
      V.notification.view(id, from)(Html(body))
  }
}