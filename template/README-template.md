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

```groovy
repositories {
    maven { url "https://repo.lightdream.dev/" }
}

dependencies {
    implementation "${{ env.GROUP }}:${{ env.ARTIFACT }}:${{ env.VERSION }}"
}
```
</details>
