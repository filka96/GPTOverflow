plugins {
    kotlin("jvm") version "1.8.10"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    api("com.xenomachina:kotlin-argparser:2.0.7")

    api(project(":gpt:api"))
}

application {
    mainClass.set("ai.gptoverflow.api.MainKt")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "ai.gptoverflow.api.MainKt"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
