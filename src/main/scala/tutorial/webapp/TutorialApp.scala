package tutorial.webapp
import org.scalajs.dom
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object TutorialApp {

  val NoArgs =
    ScalaComponent.static("No args")(<.div("Hello!"))

  def main(args: Array[String]): Unit = {
    import org.scalajs.dom.document
    NoArgs().renderIntoDOM(document.getElementById("container"))
  }
}
