package tutorial.webapp
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import tutorial.webapp.components.Timer
import tutorial.webapp.components.TodoApp

import scala.scalajs.js




object TutorialApp {

  val NoArgs =
    ScalaComponent.static("No args")(<.div("Hello!"))

  val MainPage =
    ScalaComponent.static("Main")(
      <.div(
        <.div("Hello Main"),
        NoArgs(),
        NoArgs(),
        NoArgs(),
        <.div("=========================="),
        Timer.Timer(),
        <.div("=========================="),
        TodoApp.TodoApp()
      )
    )

  def main(args: Array[String]): Unit = {
    import org.scalajs.dom.document
    MainPage().renderIntoDOM(document.getElementById("container"))
  }
}
