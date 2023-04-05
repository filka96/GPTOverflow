package ai.gptoverflow.gpt.app

import com.aallam.openai.api.moderation.TextModeration

fun TextModeration.toAnswerString(): String {
  return results.joinToString { it.toAnswerString() }
}

fun TextModeration.isFlagged(): Boolean {
  return results.any { it.flagged }
}
