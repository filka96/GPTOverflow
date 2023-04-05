package ai.gptoverflow.models

import kotlin.math.max
import kotlin.math.min


data class Secret(private val secret: String = "") {
  fun getUnmaskedSecret() = secret

  fun getMaskedSecret() = maskSensitiveData(secret)

  override fun toString(): String {
    return "Secret(${getMaskedSecret()})"
  }
}


fun maskSensitiveData(sensitiveData: String?, desiredPrefixLength: Int = 1, desiredSuffixLength: Int = 1): String {
  if (sensitiveData == null) {
    return "null"
  }

  val strLength = sensitiveData.length
  val maskedSymbols = max(strLength / 2 + 1, 6)

  val maxPossiblePrefixLength = max((strLength - maskedSymbols) / 2, 0)
  val effectivePrefixLen = min(desiredPrefixLength, maxPossiblePrefixLength)

  val maxPossibleSuffixLength = max(strLength - maskedSymbols - effectivePrefixLen, 0)
  val effectiveSuffixLen = min(desiredSuffixLength, maxPossibleSuffixLength)

  val prefix = sensitiveData.take(effectivePrefixLen)
  val suffix = sensitiveData.takeLast(effectiveSuffixLen)

  return "${prefix}***${suffix}"
}
