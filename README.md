![Build](../../actions/workflows/build.yml/badge.svg)
![Version](https://img.shields.io/badge/Version-1.0.0-red.svg)

## Use

<details>
  <summary>Maven</summary>

  <details>
<summary>&ensp; repo.lightdream.dev</summary>

  ```xml
<repositories>
    <repository>
        <id>lightdream-repo</id>
        <url>https://repo.lightdream.dev/</url>
    </repository>
</repositories>
  ```

  ```xml
<dependenies>
    <dependency>
        <groupId>dev.lightdream</groupId>
        <artifactId>reflections</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependenies>
  ```

  </details>
  <details>
  <summary>&ensp; jitpack.io</summary>

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

</details>

<br>

<details>
  <summary>Gradle</summary>

  <details>
    <summary>&ensp;Groovy</summary>

  <details>
<summary>&ensp;&ensp; repo.lightdream.dev</summary>

```groovy
repositories {
    maven("https://repo.lightdream.dev/")
}
```

```groovy
dependencies {
    implementation=("dev.lightdream:reflections:1.0.0")
}
```
  </details>
  <details>
  <summary>&ensp;&ensp; jitpack.io</summary>

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



  </details>

  <details>
    <summary>&ensp;Kotlin</summary>

  <details>
<summary>&ensp;&ensp; repo.lightdream.dev</summary>

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
  <summary>&ensp;&ensp; jitpack.io</summary>

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

</details>




