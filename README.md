![Build](../../actions/workflows/build.yml/badge.svg)
![Version](https://img.shields.io/badge/Version-1.0.0-red.svg)

## Use

<details>
  <summary>Maven</summary>

  <details>
<summary style="padding-left:25px">repo.lightdream.dev</summary>

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
  <summary  style="padding-left:25px">jitpack.io</summary>

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

<details>
  <summary>Gradle</summary>

  <details>
    <summary  style="padding-left:25px">Groovy</summary>

  <details>
<summary  style="padding-left:50px">repo.lightdream.dev</summary>

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
  <summary style="padding-left:50px">jitpack.io</summary>

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
    <summary style="padding-left:25px">Kotlin</summary>

  <details>
<summary style="padding-left:50px">repo.lightdream.dev</summary>

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
  <summary style="padding-left:50px">jitpack.io</summary>

```kotlin
repositories {
    maven("https://jitpack.io")
}
```

```kotlin
dependencies {
    implementation("com.github.L1ghtDream:reflections:1.0.0")
}
```



</details>

  </details>

</details>




