plugins {
    id("java")
    id("maven-publish")
}

group = "dev.lightdream"
version = "0.0.1"

repositories {
    mavenCentral()
    maven("https://repo.lightdream.dev/")
}

dependencies {
    //LightDream
    implementation("dev.lightdream:Logger:3.0.1")

    // ClassGraph
    implementation("io.github.classgraph:classgraph:4.8.154")

    // Lombok
    implementation("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    // JetBrains
    implementation("org.jetbrains:annotations:22.0.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        maven(url = project.findProperty("gitlab.url") as String) {
            credentials(HttpHeaderCredentials::class){
                name = project.findProperty("gitlab.auth.header.name") as String
                value = project.findProperty("gitlab.auth.header.value") as String
            }
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }
}