plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "0.16.0"
    id("maven-publish")
    id("org.jmailen.kotlinter") version "3.6.0"
}

group = "com.github.carlobellettini"
version = "2.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.assertj:assertj-assertions-generator:2.2.1") {
        exclude(module = "logback-classic")
    }
}

gradlePlugin {
    plugins {
        create("assertjGenerator") {
            id = "com.github.carlobellettini.assertj-generator-p"
            implementationClass = "com.github.carlobellettini.gradle.assertj.plugin.AssertjGeneratorPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/carlobellettini/assertj-generator-gradle-plugin-p"
    vcsUrl = "https://github.com/carlobellettini/assertj-generator-gradle-plugin-p"
    description = "Generate Assertj assertion classes."
    tags = listOf("code-generation", "assertj", "java")
    (plugins) {
        "assertjGenerator" {
            displayName = "Assertj Generator plugin"
        }
    }
}


tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "7.2"
}