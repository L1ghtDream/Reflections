# ${{ env.ARTIFACT }}

![Build](../../actions/workflows/build.yml/badge.svg)
![Version](https://img.shields.io/badge/Version-${{ env.VERSION }}-red.svg)

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
        <groupId>${{ env.GROUP }}</groupId>
        <artifactId>${{ env.ARTIFACT }}</artifactId>
        <version>${{ env.VERSION }}</version>
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
    
    dependencies {
        implementation "${{ env.GROUP }}:${{ env.ARTIFACT }}:${{ env.VERSION }}"
    }
    ```
  </details>

  <details>
    <summary>Kotlin</summary>

    ```kotlin
    repositories {
        maven("https://repo.lightdream.dev/")
    }
    
    dependencies {
        implementation("${{ env.GROUP }}:${{ env.ARTIFACT }}:${{ env.VERSION }}")
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
        <groupId>com.github.${{ env.GITHUB_USERNAME }}</groupId>
        <artifactId>${{ env.ARTIFACT }}</artifactId>
        <version>${{ env.VERSION }}</version>
    </dependency>
    <dependency>
        <groupId>${{ env.GROUP }}</groupId>
        <artifactId>${{ env.ARTIFACT }}</artifactId>
        <version></version>
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
    
    dependencies {
    i   mplementation "com.github.${{ env.GITHUB_USERNAME }}:${{ env.ARTIFACT }}:${{ env.VERSION }}"
    }
    ```
  </details>

  <details>
    <summary>Kotlin</summary>

    ```kotlin
    repositories {
        maven("https://jitpack.io")
    }
    
    dependencies {
        implementation("com.github.${{ env.GITHUB_USERNAME }}:${{ env.ARTIFACT }}:${{ env.VERSION }})
    }
    ```
  </details>

</details>
