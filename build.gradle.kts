plugins {
    id("java")
    id("maven-publish")
}

group = "dev.lightdream"
version = "2.0.0"

repositories {
    mavenCentral()
    maven("https://repo.lightdream.dev/")
}

dependencies {
    //LightDream
    implementation("dev.lightdream:logger:3.1.0")
    implementation("dev.lightdream:lambda:3.8.1")

    // ClassGraph
    implementation("io.github.classgraph:classgraph:4.8.154")

    // Reflections
    implementation("org.reflections:reflections:0.10.2")

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

tasks.withType<Jar> {
    archiveFileName.set("${rootProject.name}.jar")
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
        val githubURL = project.findProperty("github.url") ?: ""
        val githubUsername = project.findProperty("github.auth.username") ?: ""
        val githubPassword = project.findProperty("github.auth.password") ?: ""

        val selfURL = project.findProperty("self.url") ?: ""
        val selfUsername = project.findProperty("self.auth.username") ?: ""
        val selfPassword = project.findProperty("self.auth.password") ?: ""

        maven(url = githubURL as String) {
            name = "github"
            credentials(PasswordCredentials::class) {
                username = githubUsername as String
                password = githubPassword as String
            }
        }

        maven(url = selfURL as String) {
            name = "self"
            credentials(PasswordCredentials::class) {
                username = selfUsername as String
                password = selfPassword as String
            }
        }
    }
}

tasks.register("publishGitHub") {
    dependsOn("publishMavenPublicationToGithubRepository")
    description = "Publishes to GitHub"
}

tasks.register("publishSelf") {
    dependsOn("publishMavenPublicationToSelfRepository")
    description = "Publishes to Self hosted repository"
}
