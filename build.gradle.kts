import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "net.masterzach32"
version = "1.0"

plugins {
    kotlin("jvm") version "1.3.40"
    application
}

application {
    mainClassName = "net.masterzach32.apples.MainKt"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compile("io.netty:netty-all:4.1.36.Final")
    compile("org.jetbrains.exposed:exposed:0.15.1")
    compile("org.xerial:sqlite-jdbc:3.21.0.1")
    compile("ch.qos.logback:logback-classic:1.2.3")
    //compile("com.googlecode.json-simple:json-simple:1.1.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<JavaExec> {
    workingDir = file("$projectDir/run")
}