![Build](../../actions/workflows/build.yml/badge.svg)
![Version](https://img.shields.io/badge/Version-1.0.0-red.svg)

## Use

<details>
  <summary>Maven</summary>

  ```xml
  <repositories>
      <repository>
          <id>lightdream-repo</id>
          <url>https://repo.lightdream.dev/</url>
      </repository>
  </repositories>
  ```
  
  ```xml
  <dependencies>
      <dependency>
          <groupId>dev.lightdream</groupId>
          <artifactId>reflections</artifactId>
          <version>1.0.0</version>
      </dependency>
  </dependencies>
  ```
</details>

<details>
  <summary>Gradle</summary>

  <details>
    <summary>Groovy</summary>

    ```groovy
    repositories {
        maven { url "https://repo.lightdream.dev/" }
    }
    ```
    
    ```groovy
    dependencies {
        implementation "dev.lightdream:reflections:1.0.0"
    }
    ```
  </details>

  <details>
    <summary>Kotlin</summary>

    ```kotlin
    repositories {
        maven("https://repo.lightdream.dev/")
    }
    ```
    
    ```kotlin
    dependencies {
        implementation("dev.lightdream:reflections:1.0.0")
    }
    ```
  </details>

</details>



<details>
  <summary>Maven (jitpack)</summary>

  ```xml
  <repositories>
      <repository>
          <id>jitpack.io</id>
          <url>https://jitpack.io</url>
      </repository>
  </repositories>
  ```
  
  ```xml
  <dependencies>
      <dependency>
          <groupId>com.github.L1ghtDream</groupId>
          <artifactId>reflections</artifactId>
          <version>1.0.0</version>
      </dependency>
  </dependencies>
```
</details>

<details>
  <summary>Gradle (jitpack)</summary>
  <details>
    <summary>Groovy</summary>

    ```groovy
    repositories {
        maven { url "https://jitpack.io" }
    }
    ```
    
    ```groovy
    dependencies {
        implementation "com.github.L1ghtDream:reflections:1.0.0"
    }
    ```
  </details>

  <details>
    <summary>Kotlin</summary>

    ```kotlin
    repositories {
        maven("https://jitpack.io")
    }
    ```
    
    ```kotlin
    dependencies {
        implementation("com.github.L1ghtDream:reflections:1.0.0)
    }
    ```
  </details>

</details>
