package ai.gptoverflow.gpt.app

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletion

@OptIn(BetaOpenAI::class)
fun ChatCompletion.toAnswerString(): String {
  return toString()
}
