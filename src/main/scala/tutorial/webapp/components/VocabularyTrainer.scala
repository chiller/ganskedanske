package tutorial.webapp.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^.{<, _}

import scala.util.Random



object VocabularyTrainer {

  val exercises : Array[String] = Array(
    "tilbage", "aldrig", "sammen", "ned", "blive", "helt", "nogle"
  )

  val solutions : Array[String] = Array(
    "back", "never", "together", "down", "become", "completely", "some"
  )

  case class Exercise(question: String, answer: String, answers: Seq[String])
  case class State(
                    score: Int,
                    exercise: Option[Exercise]
                  )

  class Backend($: BackendScope[Unit, State]){

    def init(): CallbackTo[Unit] = {
      $.setState(State(0, Some(nextExercise())))
    }

    def handleSubmit(answer: String)(e: ReactEventFromInput): CallbackTo[Unit] = {
      val next = nextExercise()
      e.preventDefaultCB >> $.modState(s => {
        val score = if (s.exercise.get.answer == answer) {
          s.score + 1
        } else {
          s.score
        }
        State(score, Some(next))
      })
    }

    def nextExercise(): Exercise = {
      val index: Int = Random.nextInt(exercises.length)
      val answers = Random.shuffle(
        solutions(index) :: Random.shuffle(solutions.toList.filter(_ != solutions(index))).take(3)
      )
      Exercise(exercises(index), solutions(index), answers)
    }

    def render(s: State) = <.div(
      <.div(s"Score: ${s.score}"),
      <.div(s.exercise.map(_.question)),
      <.div(s.exercise.map(_.answers).getOrElse(List()).map( answer =>
        <.div(
          <.input(^.`type` := "radio"),
          answer,
          ^.key := answer,
          ^.onClick ==> handleSubmit(answer))
      ).toVdomArray),
    )
  }

  val component = ScalaComponent.builder[Unit]("Trainer")
    .initialState(State(0, None))
    .renderBackend[Backend]
    .componentDidMount(_.backend.init)
    .build

}
