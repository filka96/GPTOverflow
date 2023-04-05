package ai.gptoverflow.gpt.app

import com.aallam.openai.api.moderation.ModerationResult


fun ModerationResult.toAnswerString(): String {
  // todo: сделать нормальные ошибки
  return """
hate: ${categories.hate}, score:${categoryScores.hate}
hate/threatening: ${categories.hateThreatening}, score:${categoryScores.hateThreatening}
self-harm: ${categories.selfHarm}, score:${categoryScores.selfHarm}
sexual: ${categories.sexual}, score:${categoryScores.sexual}
sexual/minors: ${categories.sexualMinors}, score:${categoryScores.sexualMinors}
violence: ${categories.violence}, score:${categoryScores.violence}
violence/graphic: ${categories.violenceGraphic}, score:${categoryScores.violenceGraphic}
"""
}
