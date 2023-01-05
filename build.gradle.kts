plugins {
    id("java")
    id("maven-publish")
}

group = "dev.lightdream"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.lightdream.dev/")
}

dependencies {
    //LightDream
    implementation("dev.lightdream:Logger:+")
    implementation("dev.lightdream:Lambda:+")

    // ClassGraph
    implementation("io.github.classgraph:classgraph:4.8.154")

    // Lombok
    implementation("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    // JetBrains
    implementation("org.jetbrains:annotations:22.0.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

configurations.all {
    resolutionStrategy.cacheDynamicVersionsFor(10, "seconds")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        var gitlabURL = project.findProperty("gitlab.url")
        var gitlabHeaderName = project.findProperty("gitlab.url")
        var gitlabHeaderValue = project.findProperty("gitlab.url")

        if (gitlabURL == null) {
            gitlabURL = ""
        }
        if (gitlabHeaderName == null) {
            gitlabHeaderName = ""
        }
        if (gitlabHeaderValue == null) {
            gitlabHeaderValue = ""
        }

        maven(url = gitlabURL as String) {
            credentials(HttpHeaderCredentials::class) {
                name = gitlabHeaderName as String
                value = gitlabHeaderValue as String
            }
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }
}