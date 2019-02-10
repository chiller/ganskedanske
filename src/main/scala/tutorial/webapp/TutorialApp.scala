package tutorial.webapp
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import tutorial.webapp.components.{Timer, TodoApp, VocabularyTrainer}

object TutorialApp {

  val NoArgs =
    ScalaComponent.static("No args")(<.div("Hello!"))

  val MainPage =
    ScalaComponent.static("Main")(
      <.div(
        <.div("=========================="),
        VocabularyTrainer.component(),
        <.div("==========================")
      )
    )

  def main(args: Array[String]): Unit = {
    import org.scalajs.dom.document
    MainPage().renderIntoDOM(document.getElementById("container"))
  }
}
