[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.denisgasparoto.chucknorrisfacts&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.denisgasparoto.chucknorrisfacts)

# Facts

Android app written in Kotlin.

## Continuous Integration

Runs Detekt
```
./gradlew detekt
```

Runs Unit Tests
```
./gradlew test
```

Runs Jacoco
```
./gradlew clean build jacocoUnitTestReport
```
