package ai.gptoverflow.gpt.app

import ai.gptoverflow.models.Secret
import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.api.moderation.ModerationRequest
import com.aallam.openai.client.OpenAI
import com.aallam.openai.client.OpenAIConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

@OptIn(BetaOpenAI::class)
class ChatGptClientImpl(private val apiToken: Secret) {
  fun getAnswer(questionModel: GptQuestionModel): GptAnswerModel = runBlocking {

    val config = OpenAIConfig(
      token = apiToken.getUnmaskedSecret(),
      timeout = Timeout(socket = 60.seconds),
    )

    val openAI = OpenAI(config)

    val moderation = openAI.moderations(
      request = ModerationRequest(
        input = listOf(questionModel.question),
      )
    )
    if (moderation.isFlagged()) {
      return@runBlocking GptAnswerModel(moderation = moderation.toAnswerString())
    }

    val completionRequest = ChatCompletionRequest(
      model = ModelId("gpt-3.5-turbo"),
      messages = listOf(
        ChatMessage(
          role = ChatRole.User,
          content = questionModel.question,
        )
      ),
    )
    return@runBlocking GptAnswerModel(
      answer = openAI.chatCompletion(request = completionRequest).toAnswerString()
    )
  }
}
