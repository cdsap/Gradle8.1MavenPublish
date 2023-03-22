import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
    id ("maven-publish")
    id ("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "1.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

gradlePlugin {
    plugins {
        create("InfoKotlinProcessPlugin") {
            id = "io.github.test.test"
            displayName = "Info Kotlin Processes"
            description = "Retrieve information of the Kotlin processes after the build execution"
            implementationClass = "io.github.cdsap.kotlinprocess.InfoKotlinProcessPlugin"
        }
    }
}
