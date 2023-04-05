plugins {
  kotlin("jvm") version "1.8.10"
  application
}

repositories {
  mavenCentral()
}

dependencies {
  api(project(":shared:models"))

  api("com.aallam.openai:openai-client:3.2.0")
  api("io.ktor:ktor-client-okhttp-jvm:2.2.4")
}
