plugins {
    kotlin("jvm") version "1.8.10"
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":gpt:app"))
}

tasks.withType<Jar> {
    archiveFileName.set("gpt-api.jar")
}
