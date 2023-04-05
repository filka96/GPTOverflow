package ai.gptoverflow.api

import ai.gptoverflow.gpt.api.ChatGptClient
import ai.gptoverflow.gpt.app.GptQuestionModel
import ai.gptoverflow.models.Secret
import com.xenomachina.argparser.ArgParser

fun main(args: Array<String>) {
  val appArgs = ArgParser(args).parseInto(::AppArgs)

  println(appArgs)
  println(
    ChatGptClient(Secret(secret = appArgs.gptToken))
      .getAnswer(GptQuestionModel(question = appArgs.query.joinToString(" ") { it }))
      .toString()
  )
}

class AppArgs(parser: ArgParser) {
  val gptToken by parser.positional(help = "ChatGPT token")
  val query by parser.positionalList(help = "ChatGPT question query")

  override fun toString(): String {
    return "gptToken:${gptToken}, query:${query}"
  }
}
