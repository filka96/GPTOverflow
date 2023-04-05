package ai.gptoverflow.gpt.api

import ai.gptoverflow.gpt.app.ChatGptClientImpl
import ai.gptoverflow.gpt.app.GptAnswerModel
import ai.gptoverflow.gpt.app.GptQuestionModel
import ai.gptoverflow.models.Secret

class ChatGptClient(private val apiToken: Secret) {
  fun getAnswer(questionModel: GptQuestionModel): GptAnswerModel {
    return ChatGptClientImpl(apiToken = apiToken)
      .getAnswer(questionModel = questionModel)
  }
}
