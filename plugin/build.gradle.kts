plugins {
    java
}

group = "com.fossman.obviousrecipes"
version = "26.3.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.3.build.242-stable")
}

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks.jar {
    archiveFileName.set("obvious-recipes-spawners-26.3.jar")
}
